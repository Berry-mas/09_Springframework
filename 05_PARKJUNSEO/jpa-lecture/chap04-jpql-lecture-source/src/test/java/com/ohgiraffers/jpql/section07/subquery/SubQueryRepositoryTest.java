package com.ohgiraffers.jpql.section07.subquery;

import com.ohgiraffers.jpql.section08.namedquery.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubQueryRepositoryTest {


    @Autowired
    private SubQueryRepository subQueryRepository;

    @DisplayName("where절 subquery 테스트")
    @Test
    void testSelectWithSubquery() {
        String catogoryName = "한식";
        List<Menu> menuList = subQueryRepository.selectWithSubQuery(catogoryName);
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
}