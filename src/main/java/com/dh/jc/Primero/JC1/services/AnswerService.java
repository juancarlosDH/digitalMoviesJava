package com.dh.jc.Primero.JC1.services;

import com.dh.jc.Primero.JC1.model.questions.Answer;
import com.dh.jc.Primero.JC1.repository.AnswerJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    private AnswerJPARepository answerJPARepository;

    public AnswerService(AnswerJPARepository answerJPARepository)
    {
        this.answerJPARepository = answerJPARepository;
    }

    public Answer findById(Integer id) throws Exception {
        Optional<Answer> answer = this.answerJPARepository.findById(id);

        if (answer.isPresent()) {
            return answer.get();
        }

        throw new Exception("Answer not found");
    }
}
