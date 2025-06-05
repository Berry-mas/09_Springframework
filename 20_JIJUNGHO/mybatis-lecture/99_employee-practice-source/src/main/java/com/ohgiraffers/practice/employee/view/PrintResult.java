package com.ohgiraffers.practice.employee.view;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {

    public static void printMemberList(List<EmployeeDTO> memberList) {
        System.out.println("===== 멤버 목록 ======");
        for(EmployeeDTO EmployeeDTO : memberList) {
            System.out.println(EmployeeDTO);
        }
    }

    public static void printErrorMessage(String errorCode) {
        System.out.println("===== Error =====");
        String errorMessage = switch (errorCode) {
            case "selectList" -> "멤버 목록 조회에 실패했습니다.";
            case "selectOne" -> "멤버 코드로 메뉴 조회에 실패했습니다.";
            case "insert" -> "신규 멤버 등록에 실패했습니다.";
            case "update" -> "멤버 수정에 실패했습니다.";
            case "delete" -> "멤버 삭제에 실패했습니다.";
            default -> "";
        };

        System.out.println(errorMessage);
    }

    public void printMenu(EmployeeDTO employee) {
        System.out.println("====== 조회된 멤버 =====");
        System.out.println(employee);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success =====");
        String successMessage = switch (successCode) {
            case "insert" -> "신규 멤버 등록이 완료 되었습니다.";
            case "update" -> "멤버 수정이 완료 되었습니다.";
            case "delete" -> "멤버 삭제가 완료 되었습니다.";
            default -> "";
        };
        System.out.println(successMessage);
    }
}
