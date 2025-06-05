package ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Section01Menu")
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

}
