package com.ohgiraffers.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        
        String[] definitions = applicationContext.getBeanDefinitionNames();
        for (String definition : definitions) {
            System.out.println("definition = " + definition);
        }

        PokemonService pokemonService = applicationContext.getBean(PokemonService.class);
        pokemonService.pokemonAttack();

    }
}
