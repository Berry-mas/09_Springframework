package com.ohgiraffers.entity.section04.inheritance.section02.joined;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoinedService {

    private JoinedRepository joinedRepository;

    public JoinedService(JoinedRepository joinedRepository) {
        this.joinedRepository = joinedRepository;
    }

    @Transactional
    public void registDeveloperAndManager(DeveloperAndManagerDTO dm) {

        Developer developer = new Developer(null, dm.getDName(), dm.getDContact(), dm.getDLang());
        Manager manager = new Manager(null, dm.getDName(), dm.getDContact(), dm.getDLang());

        joinedRepository.registDeveloperAndManager(developer, manager);
    }
    @Transactional
    public List<Employee> selectEmployeeAll(String jpql) {
       List<Employee> employees = joinedRepository.selectEmployeeAll(jpql);
       return employees;
    }
}
