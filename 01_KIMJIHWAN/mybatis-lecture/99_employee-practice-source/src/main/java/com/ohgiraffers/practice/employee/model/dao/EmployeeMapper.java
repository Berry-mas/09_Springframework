package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeDTO> selectEmpAll();
}
