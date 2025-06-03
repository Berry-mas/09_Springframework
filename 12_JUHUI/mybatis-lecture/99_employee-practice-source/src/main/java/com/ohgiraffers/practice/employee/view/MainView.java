package com.ohgiraffers.practice.employee.view;

import com.ohgiraffers.practice.employee.controller.EmployeeController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeController employeeController = new EmployeeController(); // 컨트롤러와 연결하기 위해 인스턴스 생성

        while(true) {
            System.out.println("===== 회원 관리 ======");
            System.out.println("1. 회원 전체 조회"); // 조회만 하는거니까 controller에서 연결해서 가져오고
            System.out.println("2. 회원 코드로 메뉴 조회"); // 이건 값이 필요하니까 따로 만드는거
            System.out.println("3. 회원 추가");
            System.out.println("4. 회원 수정");
            System.out.println("5. 회원 삭제");
            System.out.print("회원 관리 번호 입력 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    employeeController.selectAllEmployee(); break;
                case 2:
                    employeeController.selectEmployeeById(inputEmpId());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("잘못 된 번호를 선택하셨습니다.");
            }
        }
    }

    // 1번까지만 함.
    private static Map<String, String> inputEmpId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 아이디 입력 : ");
        String empId = sc.nextLine();
        Map<String, String> parameter = new HashMap<>();
        parameter.put("empId", empId);
        return parameter;
    }
}
