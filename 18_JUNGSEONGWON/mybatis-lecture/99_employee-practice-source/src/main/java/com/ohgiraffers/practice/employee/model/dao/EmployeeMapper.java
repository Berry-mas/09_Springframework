package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    public List<EmployeeDTO> selectAllMember();

    List<EmployeeDTO> selectMemberByCode();

    EmployeeDTO selectEmployeeById(Map<String, String> parameter);

    int insertEmployee(EmployeeDTO emp);
}
