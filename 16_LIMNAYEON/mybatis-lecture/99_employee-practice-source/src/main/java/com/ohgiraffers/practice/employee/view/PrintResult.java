package com.ohgiraffers.practice.employee.view;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {

    public void printEmpList(List<EmployeeDTO> empList) {
        System.out.println("===== 회원 목록 ======");
        for(EmployeeDTO employeeDTO : empList) {
            System.out.println(employeeDTO);

        }
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("===== Error =====");
        String errorMessage = switch (errorCode) {
            case "selectList" -> "회원 목록 조회에 실패했습니다.";
            case "selectOne" -> "회원 코드로 메뉴 조회에 실패했습니다.";
            case "insert" -> "회원 등록에 실패했습니다.";
            case "update" -> "회원 수정에 실패했습니다.";
            case "delete" -> "회원 삭제에 실패했습니다.";
            default -> "";
        };

        System.out.println(errorMessage);
    }

    public void printEmp(EmployeeDTO emp) {
        System.out.println("======== 조회된 회원 ============");
        System.out.println(emp);
    }
}
