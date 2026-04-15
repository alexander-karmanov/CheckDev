package ru.checkdev.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryNotificationEventDTO {
    private List<Integer> categorySubscriberIds;
    private CategoryWithTopicDTO categoryWithTopicDTO;
}
