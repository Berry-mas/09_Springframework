package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name="Role0303")
@Table(name="tbl_role_0303")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    private String id;
    private String name;

    @ElementCollection(fetch= FetchType.EAGER)
    @CollectionTable(
            name = "tbl_role_permission_0303",
            joinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Permission> permissions;

    public void changePermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
