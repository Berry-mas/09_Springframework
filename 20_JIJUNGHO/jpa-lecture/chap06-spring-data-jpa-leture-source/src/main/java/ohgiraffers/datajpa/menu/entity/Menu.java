package ohgiraffers.datajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Getter
@NoArgsConstructor (access = AccessLevel.PUBLIC)
@Builder
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenuName (String menuName) {
        this.menuName = menuName;
    }
}
