package com.dh.jc.Primero.JC1.controller.rest;

import com.dh.jc.Primero.JC1.model.questions.Answer;
import com.dh.jc.Primero.JC1.model.questions.Question;
import com.dh.jc.Primero.JC1.services.AnswerService;
import com.dh.jc.Primero.JC1.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;
    private AnswerService answerService;

    public QuestionController(QuestionService questionService, AnswerService answerService)
    {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/quizz/{id}")
    public String getQuestion(@PathVariable(value = "id") Integer id, Model model)
    {
        try {
            Question question = this.questionService.findById(id);
            model.addAttribute("question", question);
            return "questions/question-answers";
        } catch (Exception e) {
            return "questions/not-found";
        }
    }

    @PostMapping("/quizz/{id}")
    public String answerQuestion(@PathVariable(value = "id") Integer id, @ModelAttribute("answer") Integer answer_id, Model model)
    {
        try {
            Question question = this.questionService.findById(id);
            Answer answer = this.answerService.findById(answer_id);

            Boolean correct = this.questionService.isCorrectAnswer(question, answer);

            model.addAttribute("question", question);
            model.addAttribute("answer", answer);
            model.addAttribute("correct", correct);

            return "questions/question-answered";
        } catch (Exception e) {
            return "questions/not-found";
        }
    }

}
