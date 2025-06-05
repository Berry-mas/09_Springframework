package com.ohgiraffers.entity.section04.inheritance.section03.table.per.clazz;

import com.ohgiraffers.entity.section04.inheritance.section02.joined.JoinedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClazzService {

    private ClazzRepository clazzRepository;

    public ClazzService(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

    @Transactional
    public void registDeveloperAndManager(DeveloperAndManagerDTO dm) {
        Developer developer = new Developer(null, dm.getDName(), dm.getDContact(), dm.getDLang());
        Manager manager = new Manager(null, dm.getDName(), dm.getDContact(), dm.getDLang());

        clazzRepository.registDeveloperAndManager(developer, manager);
    }

    @Transactional
    public List<Employee> selectEmployeeAll(String jqpl){
        List<Employee> employees = clazzRepository.selectEmployeeAll(jqpl);
        return employees;
    }

}
