package com.ohgiraffers.datajpa.menu.mapper;

import com.ohgiraffers.datajpa.menu.dto.MenuDTO;
import com.ohgiraffers.datajpa.menu.entity.Menu;
//  수동 매핑 메서드
public class MenuMapperManual {

    // entity -> dto 직접 매핑
    public static MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setMenuCode(menu.getMenuCode());
        dto.setMenuName(menu.getMenuName());
        dto.setMenuPrice(menu.getMenuPrice());
        dto.setCategoryCode(menu.getCategoryCode());
        dto.setOrderableStatus(menu.getOrderableStatus());
        return dto;
    }

    // dto -> entity 직접 매핑
    public static Menu toEntity(MenuDTO dto) {

        // 생성자 패턴
//        return new Menu(dto.getMenuCode(), dto.getMenuName(), dto.getMenuPrice(), dto.getCategoryCode(), dto.getOrderableStatus());

        // 빌더 패턴
        return Menu.builder()
                .menuCode(dto.getMenuCode())
                .menuName(dto.getMenuName())
                .menuPrice(dto.getMenuPrice())
                .categoryCode(dto.getCategoryCode())
                .orderableStatus(dto.getOrderableStatus())
                .build();

    }
}
