package ru.checkdev.notification.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.dto.FeedbackNotificationDTO;
import ru.checkdev.notification.dto.FeedbackNotificationEventDTO;

@Service
@RequiredArgsConstructor
public class FeedbackNotificationProducer {

    private final KafkaTemplate<String, FeedbackNotificationEventDTO> kafkaTemplate;

    public void sendFeedbackNotificationEvent(FeedbackNotificationDTO dto) {
        FeedbackNotificationEventDTO event = new FeedbackNotificationEventDTO(dto);
        kafkaTemplate.send("feedback-notification-topic", event);
    }
}
