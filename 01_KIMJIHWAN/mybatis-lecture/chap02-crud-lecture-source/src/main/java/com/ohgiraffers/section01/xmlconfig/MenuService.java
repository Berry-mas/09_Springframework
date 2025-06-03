package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {

        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

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

        /* 같은 DML이라 방식은 작성 방식은 같고, menuDAO 참조 메소드만 바꿔주면 된다. */

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);


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

        int result = menuDAO.deleteMenu(sqlSession, menuCode);


        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
