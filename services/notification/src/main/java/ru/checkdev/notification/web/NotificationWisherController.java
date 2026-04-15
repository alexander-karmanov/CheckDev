package ru.checkdev.notification.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.checkdev.notification.dto.WisherApprovedDTO;
import ru.checkdev.notification.kafka.ApprovedNotificationProducer;
import ru.checkdev.notification.service.NotificationMessagesService;


@Tag(name = "NotificationApprovedWisherController", description = "NotificationApprovedWisher REST API")
@RestController
@RequestMapping("/notificationWisher")
@AllArgsConstructor
public class NotificationWisherController {

    private final NotificationMessagesService notificationMessagesService;
    private final ApprovedNotificationProducer approvedNotificationProducer;

    @PostMapping("/approvedWisher/")
    public void sendMessageApprovedWisher(
            @RequestBody WisherApprovedDTO wisherApprovedNotifyDTO) {
        approvedNotificationProducer.sendApprovedNotificationEvent(wisherApprovedNotifyDTO);
    }
}
