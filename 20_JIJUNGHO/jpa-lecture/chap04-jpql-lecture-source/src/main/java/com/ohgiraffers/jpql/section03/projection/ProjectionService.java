package com.ohgiraffers.jpql.section03.projection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectionService {
    private final ProJectionRepository proJectionRepository;

    public ProjectionService(ProJectionRepository proJectionRepository) {
        this.proJectionRepository = proJectionRepository;
    }

    @Transactional
    public List<Menu> singleEntityProjection() {
        List<Menu> menus = proJectionRepository.singleEntityProjection();
        menus.get(0).setMenuName("세상에서 제일 맛있는 유니콘 고기");
        return menus;
    }
}
