package com.ohgiraffers.practice.common;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {

    public void printEmployeeList(List<EmployeeDTO> employeeList) {
        System.out.println("===== 회원 목록 ======");
        for(EmployeeDTO employeeDTO : employeeList) {
            System.out.println(employeeDTO);
        }
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("===== Error =====");
        String errorMessage = switch (errorCode) {
            case "selectList" -> "회원 목록 조회에 실패했습니다.";
            case "selectOne" -> "회원 ID로 회원 조회에 실패했습니다.";
//            case "insert" -> "신규 메뉴 등록에 실패했습니다.";
//            case "update" -> "메뉴 수정에 실패했습니다.";
//            case "delete" -> "메뉴 삭제에 실패했습니다.";
            default -> "";
        };

        System.out.println(errorMessage);
    }

    public void printEmployee(EmployeeDTO employee) {
        System.out.println("===== 조회된 회원 ======");
        System.out.println(employee);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success =====");
        String successMessage = switch (successCode) {
//            case "insert" -> "신규 메뉴 등록이 완료 되었습니다.";
//            case "update" -> "메뉴 수정이 완료 되었습니다.";
//            case "delete" -> "메뉴 삭제가 완료 되었습니다.";
            default -> "";
        };
        System.out.println(successMessage);
    }
}
