package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /*
        * 기본 자료형의 변수명으로는 if문의 조건에서 값을 비교할 수 없다.
        *
        * Map에 기본 자료형 값을 담아 전달하도록 한다.
        * (Map의 key값, DTO 객체의 필드값)
        * */

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null || menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void selectMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.selectMenu(searchCriteria);

        if(menuList != null || !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null || !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(Set<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Set<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);

        if(menuList != null || !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null || !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.updateMenu(criteria);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 정보 변경을 완료했습니다.");
        } else {
            sqlSession.rollback();
            System.out.println("메뉴 정보 변경을 실패했습니다.");
        }
        sqlSession.close();
    }
}
