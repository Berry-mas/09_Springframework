package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting2;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserSettingDTO {

    private Long id;
    private Long userId;
    private LocalDateTime updatedAt;
    private Map<String, PropValue> props;
}
