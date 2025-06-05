package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth1;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("roleService1")
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void registRole(RoleDTO roleDTO){
        Role role = Role.builder()
                .id(roleDTO.getId())
                .name(roleDTO.getName())
                .permissions(roleDTO.getPermissions()).build();

        roleRepository.registRole(role);

        Role role2 = roleRepository.findById(roleDTO.getId());

        System.out.println("role2 = "+ role2.getName());
        System.out.println("----------------------------");
        System.out.println("role.getPermissions( = " + role.getPermissions());
    }

    @Transactional
    public void modifyRole(String id, Set<String> newPermissions){

        Role role = roleRepository.findById(id);
        System.out.println("role check ===>> " + role);
        role.changePermission(newPermissions);
    }
}
