package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

import static java.awt.SystemColor.menu;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession(); // 객체 가져옴

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenuByMenuCode(menuCode);
        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menu);

        /* Database에 DML(insert, update, delete)작업을 수행하면 트랜잭션처리를 진행해야한다.
        * (왜냐하면 처음에 설정을 할 때 커밋은 수동 커밋으로 내가 원하는 때 완료하기로 해서)
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

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menuCode);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
