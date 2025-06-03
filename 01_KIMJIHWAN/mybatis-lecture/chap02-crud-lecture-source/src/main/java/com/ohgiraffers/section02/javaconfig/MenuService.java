package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    // menuDAO를 menuMapper로 바꿔줘야 하며

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenuByMenuCode(menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);

        /* Database에 DML(insert, update, delete)작업을 수행하면 뭐하지???
        * 트랜잭션처리를 진행해야한다. (왜냐면 처음에 설정을 할 때 커밋은 수동커밋으로 내가 원하는 때 완료하기로 해서)
        * */
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);


        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(int menuCode) {

        /* 같은 DML이라 방식은 작성 방식은 같고, menuDAO 참조 메소드만 바꿔주면 된다. */

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);
        /* 같은 DML이라 방식은 작성 방식은 같고, menuDAO 참조 메소드만 바꿔주면 된다. */

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
