package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {

    public List<EmployeeDTO> selectEmpAll() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> empList = empMapper.selectEmpAll();

        sqlSession.close();

        return empList;
    }
}
