package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.BadRequest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount){
        if (amount > questionService.getAll().size()) {
            throw new BadRequest("Количество требуемых уникальных вопросов превышает их количество в базе");
        }

        List <Question> copyQuestions = new ArrayList<>(questionService.getAll());

        Set<Question> set = new HashSet<>();

        while (set.size() < amount) {
            Question question = QuestionService.getRandomQuestion(copyQuestions);
            set.add(question);
            copyQuestions.remove(question); // чтобы повторно не выбирать вопрос
        }

        return set;
    }
}
