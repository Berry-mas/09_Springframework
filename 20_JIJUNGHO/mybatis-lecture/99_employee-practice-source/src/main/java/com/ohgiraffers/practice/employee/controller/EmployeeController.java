package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.employee.view.PrintResult;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public class EmployeeController {
    private final EmployeeService employeeService;
    private final PrintResult printResult;

    public EmployeeController() {
        employeeService = new EmployeeService();
        printResult = new PrintResult();
    }

    public void selectAllMember() {
        List<EmployeeDTO> memberList = employeeService.selectAllMember();

        if (memberList != null && !memberList.isEmpty()) {
            PrintResult.printMemberList(memberList);
        } else {
            PrintResult.printErrorMessage("selectList");
        }
    }

    public void selectMemberByMemberCode(Map<String, String> parameter) {
        int memberCode = Integer.parseInt(parameter.get("memberCode"));
        EmployeeDTO member = employeeService.selectMemberByMemberCode(memberCode);

        if (member != null) {
            printResult.printMenu(member);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    public void registMember(Map<String, String> parameter) {
        EmployeeDTO member = new EmployeeDTO();
        member.setEmpName(parameter.get("empName"));
        member.setEmail(parameter.get("email"));

        if (employeeService.registMenu(member)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }
}
