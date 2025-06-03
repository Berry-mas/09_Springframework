package com.ohgiraffers.section01.xmlmapper;


import java.util.List;

// 가져오고 싶은것은
// 하나의 카테고리는 여러개의 메뉴정보를 가질 수 있다. 1:M(다) 관계를 표현
public class CategoryAndMenuDTO {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
    private List<MenuDTO> menuList;

    public CategoryAndMenuDTO() {
    }

    public CategoryAndMenuDTO(int categoryCode, String categoryName, Integer refCategoryCode, List<MenuDTO> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
