package com.ohgiraffers.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /*
    * offset : 조회를 시작할 위치(0부터) -> offset이 10이면 0~9넘고 10부터 조회
    * limit : 조회할 데이터의 갯수
    * */
    public List<Menu> usingPagingAPI(int offset, int limit) {
        String jpql = "SELECT m FROM Section04Menu m ORDER BY m.menuCode ASC";

        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        return menuList;
    }
}
