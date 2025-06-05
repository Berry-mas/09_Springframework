package com.ohgiraffers.practice.employee.model.dao;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeDTO> selectAllMember();

    EmployeeDTO selectMemberByMemberCode(int memberCode);

    int insertMember(EmployeeDTO member);
}
