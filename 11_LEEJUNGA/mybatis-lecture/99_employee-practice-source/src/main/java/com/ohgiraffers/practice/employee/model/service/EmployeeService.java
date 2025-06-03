package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {
    public List<EmployeeDTO> selectAllEmployee() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = mapper.selectAllEmployee();

        sqlSession.close();

        return employeeList;
    }

    public EmployeeDTO selectEmployeeByEmpId(int empId) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("empId", empId);

        EmployeeDTO employee = mapper.selectEmployeeByEmpId(map);

        sqlSession.close();

        return employee;
    }
}
