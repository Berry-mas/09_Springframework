package com.ohgiraffers.datajpa.menu.dto;

import com.ohgiraffers.datajpa.menu.entity.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public static MenuDTO changeMenuDto(Menu menu){
        MenuDTO menuDto = MenuDTO.builder()
                .menuCode(menu.getMenuCode())
                .menuName(menu.getMenuName())
                .menuPrice(menu.getMenuPrice())
                .categoryCode(menu.getCategoryCode())
                .orderableStatus(menu.getOrderableStatus()).build();
        return menuDto;
    }
}
