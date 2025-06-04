package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableService {

    private TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Transactional
    public void registDeveloperAndManager(DeveloperAndManagerDTO dm){

        Developer developer = new Developer(null, dm.getDName(), dm.getDContact(), dm.getDLang());
        Manager manager = new Manager(null, dm.getMName(), dm.getMContact(), dm.getMlevel());

        tableRepository.registDeveloperAndManager(developer, manager);
    }

}
