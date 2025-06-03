package com.ohgiraffers.section03.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.Template.getSqlSession;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllmenu();

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

        /* Database에 DML(insert,update,delete)작업을 수행할 때
        * 트랜잭션를 진행해야 한다.(왜냐하면 처음에 설정을 할때 커밋은 수동커밋으로 내가 원하는 때 완료하기로해서)*/
        if(result >0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);

        if(result >0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);

        if(result >0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
