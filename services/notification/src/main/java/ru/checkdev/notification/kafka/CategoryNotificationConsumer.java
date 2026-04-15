package ru.checkdev.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.dto.CategoryNotificationEventDTO;
import ru.checkdev.notification.service.NotificationMessagesService;

@Service
public class CategoryNotificationConsumer {
    private final NotificationMessagesService notificationMessagesService;

    public CategoryNotificationConsumer(NotificationMessagesService notificationMessagesService) {
        this.notificationMessagesService = notificationMessagesService;
    }

    @KafkaListener(topics = "category-notification-topic")
    public void handleCategoryNotification(CategoryNotificationEventDTO event) {
        notificationMessagesService.sendMessagesToCategorySubscribers(
                event.getCategorySubscriberIds(),
                event.getCategoryWithTopicDTO()
        );
    }
}
