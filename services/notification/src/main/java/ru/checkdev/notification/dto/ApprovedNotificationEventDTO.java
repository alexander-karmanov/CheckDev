package ru.checkdev.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovedNotificationEventDTO {
    private WisherApprovedDTO wisherApprovedDTO;
}
