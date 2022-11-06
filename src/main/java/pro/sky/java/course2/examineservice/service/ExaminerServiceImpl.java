package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount){
        /*Question q1 = questionService.getRandomQuestion();
        Question q2 = questionService.getRandomQuestion();

        Collection <Question> questionCollection = Stream.of(q1,q2).collect(Collectors.toList());
        return questionCollection;*/
        return null; // ДОПИСАТЬ
    }
}
