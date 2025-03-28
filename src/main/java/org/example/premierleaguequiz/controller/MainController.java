package org.example.premierleaguequiz.controller;

import org.example.premierleaguequiz.service.TogetherAIService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class QuizController {
    private final TogetherAIService togetherAIService;

    public QuizController(TogetherAIService togetherAIService) {
        this.togetherAIService = togetherAIService;
    }

    @GetMapping
    public String home(Model model) {
        String quizQuestion = togetherAIService.generateQuizQuestion("Premier League players");
        model.addAttribute("quizQuestion", quizQuestion);
        return "quiz";
    }
}