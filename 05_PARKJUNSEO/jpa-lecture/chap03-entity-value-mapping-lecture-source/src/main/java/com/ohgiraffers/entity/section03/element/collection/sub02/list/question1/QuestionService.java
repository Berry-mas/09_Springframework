package com.ohgiraffers.entity.section03.element.collection.sub02.list.question1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void registQuestion(QuestionDTO questionDTO) {
        Question question = Question.builder()
                .text(questionDTO.getText())
                .choices(questionDTO.getChoices()).build();

        questionRepository.registQuestion(question);
    }

    @Transactional
    public void modifyQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository.findById(questionDTO.getId());
        question.changeChoices(questionDTO.getChoices());
    }
}
