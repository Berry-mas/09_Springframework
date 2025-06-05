package com.ohgiraffers.nativequery.section02.namedquery;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Section02Category")
@Table(name="tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@NamedNativeQuery(
        name = "Category.menuCountOfCategory",
        query = "SELECT c.category_code, c.category_name, c.ref_category_code, COUNT(m.menu_code) AS menu_count " +
                "FROM tbl_category c " +
                "JOIN tbl_menu m ON c.category_code = m.category_code " +
                "GROUP BY c.category_code, c.category_name, c.ref_category_code",
        resultSetMapping = "categoryCountManualMapping2"
)
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "categoryCountManualMapping2",
                entities = {
                        @EntityResult(
                                entityClass = Category.class,
                                fields = {
                                        @FieldResult(name = "categoryCode", column = "category_code"),
                                        @FieldResult(name = "categoryName", column = "category_name"),
                                        @FieldResult(name = "refCategoryCode", column = "ref_category_code")
                                }
                        )
                },
                columns = {@ColumnResult(name = "menu_count")}
        )
})
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
