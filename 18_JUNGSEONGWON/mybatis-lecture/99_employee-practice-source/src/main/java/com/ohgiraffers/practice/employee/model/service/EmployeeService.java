package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.lang.constant.DynamicCallSiteDesc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {
    public List<EmployeeDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> empList = mapper.selectAllMember();
        sqlSession.close();

        return empList;
    }

    public EmployeeDTO selectMemberByCode(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        EmployeeDTO emp = employeeMapper.selectEmployeeById(parameter);

        sqlSession.close();

        return emp;
    }


    public boolean addMember(EmployeeDTO emp) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);  // 매퍼 인터페이스 사용

        int result = mapper.insertEmployee(emp);  // EmployeeMapper.xml에 정의된 insert 쿼리 사용

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

}
