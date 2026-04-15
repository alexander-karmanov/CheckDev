package ru.checkdev.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.dto.FeedbackNotificationEventDTO;
import ru.checkdev.notification.service.NotificationMessagesService;

@Service
public class FeedbackNotificationConsumer {
    private final NotificationMessagesService notificationMessagesService;

    public FeedbackNotificationConsumer(NotificationMessagesService notificationMessagesService) {
        this.notificationMessagesService = notificationMessagesService;
    }

    @KafkaListener(topics = "feedback-notification-topic")
    public void handleFeedbackNotification(FeedbackNotificationEventDTO event) {
        notificationMessagesService.sendFeedbackNotification(event.getFeedbackNotification());
    }
}
