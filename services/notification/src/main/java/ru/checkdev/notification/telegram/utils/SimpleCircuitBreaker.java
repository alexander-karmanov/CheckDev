package ru.checkdev.notification.telegram.utils;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@Component
public class SimpleCircuitBreaker {

    private enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    private State state = State.CLOSED;
    private long openUntil = 0;
    private int failures = 0;

    public <T> Mono<T> execute(Supplier<Mono<T>> request) {
        return Mono.defer(() -> {
            if (state == State.OPEN && System.currentTimeMillis() > openUntil) {
                state = State.HALF_OPEN;
            }

            return switch (state) {
                case CLOSED -> request.get().doOnError(e -> transitionToOpen());
                case OPEN -> Mono.error(new RuntimeException("CircuitBreaker OPEN"));
                case HALF_OPEN -> request.get().doOnSuccess(s -> transitionToClosed()).doOnError(e -> transitionToOpen());
            };
        });
    }

    private void transitionToOpen() {
        failures++;
        if (failures >= 3) {
            state = State.OPEN;
            openUntil = System.currentTimeMillis() + 30_000;
        }
    }

    private void transitionToClosed() {
        state = State.CLOSED;
        failures = 0;
    }
}
