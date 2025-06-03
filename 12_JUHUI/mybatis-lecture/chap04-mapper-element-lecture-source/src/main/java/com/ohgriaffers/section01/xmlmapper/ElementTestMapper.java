package com.ohgriaffers.section01.xmlmapper;

import java.util.List;

public interface ElementTestMapper {

    List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
