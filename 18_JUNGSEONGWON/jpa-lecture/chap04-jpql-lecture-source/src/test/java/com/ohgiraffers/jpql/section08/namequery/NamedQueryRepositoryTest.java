package com.ohgiraffers.jpql.section08.namequery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NamedQueryRepositoryTest {

    @Autowired
    private NamedQueryRepository namedQueryRepository;

    @DisplayName("동적 쿼리를 이용한 조회 테스트")
    @Test
    void testSelectByDynamicQuery(){
        String searchName = "마늘";
        int searchCode = 4;
        List<Menu> menuList = namedQueryRepository.selectByDynamicQuery(searchName, searchCode);
        assertNotNull(menuList);
    }

    @DisplayName("NamedQuery를 이용한 조회 테스트")
    @Test
    void testSelectByNamedQuery(){
        List<Menu> menuList = namedQueryRepository.selectByNamedQuery();
        assertNotNull(menuList);

    }
    
    @DisplayName("xml 기반 NamedQuery를 이용한 조회 테스트")
    @Test
    public void testSelectByNamedQueryWithXml(){
        //given
        int menuCode = 20;
        
        // when
        Menu foundMenu = namedQueryRepository.selectByNamedQueryWithXml(menuCode);
        // then
        assertNotNull(foundMenu);
        System.out.println("foundMenu = " + foundMenu);
    }
}