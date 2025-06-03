package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllmenu(SqlSession sqlSession) {
        // statement에 들어갈 값 : namespace.id
        return sqlSession.selectList("MenuMapper.selectAllmenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        /*
        1개의 타입 말고도 다른 타입도 가지고 오고 싶은 경우 MenuDTO를 가져와 사용하거나
        * MenuDTO
        * CategoryDTO >> Map<String, Object>
        Map 함수를 사용해서 가지고오면 된다.
        * map.put("menu",menu)
        * map.put("category",category)*/
        /* 메소드의 두번째 인수로 SQL 구문 수행 시 필요한 객체를 전달*/
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode",menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu",menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu",menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu",menuCode);
    }
}
