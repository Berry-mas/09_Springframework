package com.ohgiraffers.section03;

import com.ohgiraffers.common.MenuDTO;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SqlBuilderService sqlBuilderService = new SqlBuilderService();

        do {
            System.out.println("===== SqlBuilder 서브 메뉴 =====");
            System.out.println("1. 새로운 메뉴 추가");
            System.out.println("2. 기존 메뉴 수정");
            System.out.println("3. 기존 메뉴 삭제");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 입력 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : sqlBuilderService.registMenu(inputNewMenu()); break;
//                case 2 : sqlBuilderService.modifyMenu(inputModifyMenu()); break;
//                case 3 : sqlBuilderService.deleteMenu(inputMenuCode()); break;
                case 9 : return;
            }

        } while(true);
    }

    private static MenuDTO inputNewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("등록할 메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("등록할 메뉴의 가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.print("등록할 카테고리를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("판매 등록 여부를 입력하세요(Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(name);
        menu.setMenuPrice(price);
        menu.setCategoryCode(categoryCode);
        menu.setOrderableStatus(orderableStatus);

        return menu;
    }
}
