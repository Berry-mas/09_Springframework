package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.employee.view.PrintResult;

import java.util.List;
import java.util.Map;

public class EmployeeController {

    private final EmployeeService employeeService;
    private final PrintResult printResult;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.printResult = new PrintResult();
    }

    public void selectEmployeeAll() {

        List<EmployeeDTO> empList = employeeService.selectEmployeeAll();

        if(empList != null && !empList.isEmpty()) {
            printResult.printEmpList(empList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void selectEmployeeById(Map<String, String> parameter) {

        EmployeeDTO emp = employeeService.selectEmployeeById(parameter);

        if(emp != null) {
            printResult.printEmp(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }
}
