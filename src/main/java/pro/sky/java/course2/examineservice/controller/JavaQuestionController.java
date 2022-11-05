package pro.sky.java.course2.examineservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java")
    Collection <Question> getQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/java/remove")
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }
}
