package com.ohgiraffers.associationmapping.section02.ontomany;

import org.springframework.stereotype.Service;

@Service
public class OneToManyService {

    private OneToManyRepository oneToManyRepository;

    public OneToManyService(OneToManyRepository oneToManyRepository) {
        this.oneToManyRepository = oneToManyRepository;
    }

    public Category findCategory(int categoryCode){
        Category category = oneToManyRepository.find(categoryCode);
        System.out.println("category ===>>> " + category);

        return category;
    }
}
