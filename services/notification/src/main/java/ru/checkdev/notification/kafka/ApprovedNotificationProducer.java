package ru.checkdev.notification.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.dto.ApprovedNotificationEventDTO;
import ru.checkdev.notification.dto.WisherApprovedDTO;

@Service
@RequiredArgsConstructor
public class ApprovedNotificationProducer {
    private final KafkaTemplate<String, ApprovedNotificationEventDTO> kafkaTemplate;

    public void sendApprovedNotificationEvent(WisherApprovedDTO dto) {
        ApprovedNotificationEventDTO event = new ApprovedNotificationEventDTO(dto);
        kafkaTemplate.send("approved-notification-topic", event);
    }
}
