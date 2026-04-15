package ru.checkdev.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.dto.ApprovedNotificationEventDTO;
import ru.checkdev.notification.service.NotificationMessagesService;

@Service
public class ApprovedNotificationConsumer {
    private final NotificationMessagesService notificationMessagesService;

    public ApprovedNotificationConsumer(NotificationMessagesService notificationMessagesService) {
        this.notificationMessagesService = notificationMessagesService;
    }

    @KafkaListener(topics = "approved-notification-topic")
    public void handleApprovedNotification(ApprovedNotificationEventDTO event) {
        notificationMessagesService.sendApprovedNotification(event.getWisherApprovedDTO());
    }
}
