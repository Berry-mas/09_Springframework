package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {

    public List<EmployeeDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper memberMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> memberList = memberMapper.selectAllMember();

        sqlSession.close();

        return memberList;
    }

    public EmployeeDTO selectMemberByMemberCode(int memberCode) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper memberMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeDTO menu = memberMapper.selectMemberByMemberCode(memberCode);

        sqlSession.close();
        return menu;
    }

    public boolean registMenu(EmployeeDTO member) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper memberMapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = memberMapper.insertMember(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
