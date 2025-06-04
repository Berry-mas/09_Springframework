package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting2;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Entity(name="UserSetting_c")
@Table(name="tbl_user_setting_c")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private Long userId;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="tbl_user_setting_map",
            joinColumns = @JoinColumn(name="user_setting_id")
    )
    @MapKeyColumn(name="name") // Map의 key컬럼명
    private Map<String, PropValue> props;

    public void changeProp(String key, String value, boolean enabled) {
        this.props.put(key, new PropValue(value, enabled));
    }

    public void removeProp(String key) {
        this.props.remove(key);
    }

}
