package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }
    public void selectAllMember() {
        List<EmployeeDTO> empList = employeeService.selectAllMember();
        empList.forEach(System.out::println);
    }

    public void selectMemberByCode(Map<String, String> parameter) {
        // Map에서 empId 추출하는 부분 삭제
        EmployeeDTO member = employeeService.selectMemberByCode(parameter);

        if (member != null) {
            System.out.println("조회된 직원 정보:");
            System.out.println(member);  // toString() 활용
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }


    public void addMember(Map<String, String> parameter) {
        EmployeeDTO emp = new EmployeeDTO();

        emp.setEmpId(Integer.parseInt(parameter.get("empId")));  // int로 변환
        emp.setEmpNo(parameter.get("empNo"));                    // 주민등록번호는 String
        emp.setEmpName(parameter.get("empName"));                // 괄호 수정

        // 서비스 계층 메서드 호출 (메서드명 확인 필요)
        if (employeeService.addMember(emp)) {
            System.out.println("직원 등록에 성공했습니다.");
        } else {
            System.out.println("직원 등록에 실패했습니다.");
        }
    }

}
