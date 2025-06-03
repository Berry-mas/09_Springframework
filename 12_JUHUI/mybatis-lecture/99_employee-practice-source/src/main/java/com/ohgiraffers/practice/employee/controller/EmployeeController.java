package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.employee.view.PrintResult;

import java.util.List;
import java.util.Map;

public class EmployeeController {

    private final EmployeeService employeeService = new EmployeeService();// 사용하려면 연결해줘야함.
    private final PrintResult printResult = new PrintResult();

    public List<EmployeeDTO> selectAllEmployee() {
        List<EmployeeDTO> empList = employeeService.selectAllEmployee();

        if (empList != null && !empList.isEmpty()) {
            if(empList != null && !empList.isEmpty()) {
                printResult.printEmpList(empList);
            } else {
                printResult.printErrorMessage("selectList");
            }
        }

        return empList;
    } // 여기까지 했음.

    public void selectEmployeeById(Map<String, String> parameter) {

        EmployeeDTO emp = employeeService.selectEmployeeById(parameter);

        if(emp != null) {
            printResult.printEmp(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }
}
