package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting1;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class UserSettingDTO {

    private Long id;
    private Long userId;
    private LocalDateTime updatedAt;
    private Map<String, String> props;
}
