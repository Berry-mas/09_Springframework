package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service("roleService2")
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
    }

    @Transactional
    public void modifyRole(RoleDTO roleDTO){

        Role role = roleRepository.findById(roleDTO.getId());
        System.out.println("role check ===>> " + role);
        role.changePermissions(roleDTO.getPermissions());
    }
}
