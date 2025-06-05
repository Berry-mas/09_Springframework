package com.jsw.nativequery.section02.namedquery;

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

    @DisplayName("NameNativeQuery를 이용한 조회 테스트")
    @Test
    void testSelectByNameNativeQuery(){
        List<Object[]> categoryList = namedQueryRepository.selectByNameNativeQuery();
        assertNotNull(categoryList);
    }
}