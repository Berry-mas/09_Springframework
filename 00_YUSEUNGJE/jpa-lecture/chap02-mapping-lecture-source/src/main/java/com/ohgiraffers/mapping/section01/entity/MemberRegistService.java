package com.ohgiraffers.mapping.section01.entity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {

    private MemberRepository memberRepository;

    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // registMember메소드는 사용자 정보를 데이터베이스에 추가(insert)
    // insert, update, delete 작업이면 트랜잭션 처리
    @Transactional
    public void registMember(MemberRegistDTO newMember){
        // dto -> entity
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }

    /*
    * Spring의 트랜잭션 전파방식 : default는 PROPAGATION_REQUIRED
    * @Transactional이 붙은 메소드 내부에서 다시 @Transactional이 붙은 메소드를 호출하면
    * 호출된 메소드는 호출한 메소드와 동일한 트랜잭션 컨텍스트를 사용하게 된다.
    * */
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        registMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }
}
