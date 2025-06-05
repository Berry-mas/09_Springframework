package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {

    public List<EmployeeDTO> selectEmployeeAll() {

        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> empList = employeeMapper.selectEmployeeAll();

        sqlSession.close();

        return empList;
    }

    public EmployeeDTO selectEmployeeById(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeDTO emp = employeeMapper.selectEmployeeById(parameter);

        sqlSession.close();

        return emp;
    }
}
