package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Object selectSingleMenuByQuery(){
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        Query query = entityManager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Menu selectSingleRowByTypeQuery(){
        String jpql = "SELECT m FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu resultMenu = query.getSingleResult();
        return resultMenu;
    }

    public List<Menu> selectMultiRowByTypedQuery(){
        String jpql = "SELECT m FROM Section01Menu as m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultList = query.getResultList();
        return resultList;
    }

    /* tbl_menu의 categoryCode 중복없이 조회 */
    public List<Integer> selectUsingDistinct(){
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu as m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultList = query.getResultList();
        return resultList;
    }

    /* tbl_menu의 11, 12 카테고리 코드를 가진 메뉴 목록 조회 */
    public List<Menu> selectUsingIn(){
        String jpql = "SELECT m FROM Section01Menu as m WHERE m.categoryCode IN (11, 12)";
        List<Menu> resultList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return resultList;
    }

    /* tbl_menu의 `마늘`이 메뉴명에 포함된 메뉴 목록 조회 */
    public List<Menu> selectUsingLike(){
        String jpql = "SELECT m FROM Section01Menu as m WHERE m.menuName LIKE '%마늘%'";
        List<Menu> resultList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return resultList;
    }
}