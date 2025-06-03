package com.ohgiraffers.practice.employee.controller;



import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.employee.view.PrintView;

import java.util.List;


public class EmployeeController {
    private final EmployeeService empService;
    private final PrintView printView;

    public EmployeeController() {
        this.empService = new EmployeeService();
        this.printView = new PrintView();
    }

    public void selectEmpAll() {

        List<EmployeeDTO> empList = empService.selectEmpAll();

        if(empList != null && !empList.isEmpty()){
            printView.printEmpList(empList);
        } else {
            printView.printErrorMessage("selectList");
        }
    }
}
