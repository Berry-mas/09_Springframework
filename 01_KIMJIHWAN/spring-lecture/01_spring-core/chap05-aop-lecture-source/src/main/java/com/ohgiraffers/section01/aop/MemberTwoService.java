package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberTwoService {
    private final MemberDAO memberDAO;

    public MemberTwoService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers() 메서드 실행2");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(Long id) {
        System.out.println("selectMember() 메서드 실행2");
        return memberDAO.selectMember(id);
    }
}
