package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth1;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name="Role001")
@Table(name="tbl_role_001")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    private String id;
    private String name;
    
    /*
    * fetch
    * - fetch = FetchType.LAZY (기본값) : Role객체 조회가 아닌 실제 permission 사용직전 조회
    * - fetch = FetchType.EAGER : Role 객체 조회시 함께 조회
    * */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="tbl_role_permission_001",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @Column(name = "permission")
    Set<String> permissions;

    /* 권한 변경용 */
    public void changePermission(Set<String> newPermissions) {
        this.permissions = newPermissions;
    }
}
