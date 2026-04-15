package ru.checkdev.notification.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.checkdev.notification.dto.FeedbackNotificationDTO;
import ru.checkdev.notification.kafka.FeedbackNotificationProducer;

@RestController
@RequestMapping("/feedback")
@AllArgsConstructor
public class FeedbackNotificationController {

    private final FeedbackNotificationProducer feedbackNotificationProducer;

    @PostMapping("/interview")
    public void sendFeedbackNotification(@RequestBody FeedbackNotificationDTO feedbackNotification) {
        feedbackNotificationProducer.sendFeedbackNotificationEvent(feedbackNotification);
    }
}
