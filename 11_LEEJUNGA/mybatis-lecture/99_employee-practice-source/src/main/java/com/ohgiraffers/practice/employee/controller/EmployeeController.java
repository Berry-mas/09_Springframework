package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.common.PrintResult;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeController {
    private final EmployeeService empService;
    private final PrintResult printResult;

    public EmployeeController() {
        this.empService = new EmployeeService();
        this.printResult = new PrintResult();
    }

    public void selectAllEmployee() {
        List<EmployeeDTO> employeeList = empService.selectAllEmployee();

        if(employeeList != null && !employeeList.isEmpty()){
            printResult.printEmployeeList(employeeList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectEmployeeByEmpId() {
        EmployeeDTO employee = empService.selectEmployeeByEmpId(inputEmpId());

        if(employee != null){
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }

    }

    private static int inputEmpId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 회원 ID를 입력해주세요 : ");
        int empId = sc.nextInt();

        return empId;
    }

    public void insertEmployee() {
        EmployeeDTO employee = empService.selectEmployeeByEmpId(inputEmpId());

        if(employee != null){
            printResult.printEmployee(employee);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }
}
