package ru.checkdev.notification.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ru.checkdev.notification.dto.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryNotificationProducer {
    private final KafkaTemplate<String, CategoryNotificationEventDTO> kafkaTemplate;

    public void sendCategoryNotificationEvent(List<Integer> subscriberIds, CategoryWithTopicDTO dto) {
        CategoryNotificationEventDTO event = new CategoryNotificationEventDTO(subscriberIds, dto);
        kafkaTemplate.send("category-notification-topic", event);
    }
}
