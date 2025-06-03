package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployee();

    EmployeeDTO selectEmployeeById(Map<String, String> parameter);
}
