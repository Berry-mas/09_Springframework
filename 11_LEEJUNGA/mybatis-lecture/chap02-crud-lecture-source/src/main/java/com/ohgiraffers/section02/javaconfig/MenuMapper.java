package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MenuMapper {
    @Results(id="menuResultMap", value = {
            @Result(id=true, property = "menuCode", column = "menu_code"),
            @Result(property = "menuName", column = "menu_name"),
            @Result(property = "menuPrice", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })
    @Select("""
        SELECT
        menu_code
        , menu_name
        , menu_price
        , category_code
        , orderable_status
        FROM tbl_menu
        WHERE orderable_status = 'Y'
        ORDER BY menu_code
    """)
    List<MenuDTO> selectAllMenu();

    @ResultMap("menuResultMap")
    @Select("""
        SELECT
        menu_code
        , menu_name
        , menu_price
        , category_code
        , orderable_status
        FROM tbl_menu
        WHERE menu_code = #{menuCode}
    """)
    MenuDTO selectMenuByMenuCode(int menuCode);

    @Insert("""
        INSERT
            INTO tbl_menu(menu_name, menu_price, category_code, orderable_status)
        VALUES
            (#{menuName}, #{menuPrice}, #{categoryCode}, 'Y')
    """)
    int insertMenu(MenuDTO menu);

    @Update("""
        UPDATE tbl_menu
            SET menu_name = #{menuName}
            ,   menu_price = #{menuPrice}
            ,   category_code = #{categoryCode}
        WHERE menu_code = #{menuCode}
    """)
    int updateMenu(MenuDTO menu);

    @Delete("""
        DELETE FROM tbl_menu
        WHERE menu_code = #{menuCode}
    """)
    int deleteMenu(int menuCode);
}
