package com.ohgiraffers.entity.section03.element.collection.sub02.list.question2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionTwoService {

    private QuestionTwoRepository questionTwoRepository;

    public QuestionTwoService(QuestionTwoRepository questionTwoRepository) {
        this.questionTwoRepository = questionTwoRepository;
    }

    @Transactional
    public void registQuestion(QuestionDTO questionDTO) {

        Question question = Question.builder()
                .text(questionDTO.getText())
                .choices(questionDTO.getChoices()).build();

        questionTwoRepository.registQuestion(question);
    }

    @Transactional
    public void modifyQuestion(QuestionDTO questionDTO) {
        Question question = questionTwoRepository.findById(questionDTO.getId());
        question.changeChoices(questionDTO.getChoices());
    }
}
