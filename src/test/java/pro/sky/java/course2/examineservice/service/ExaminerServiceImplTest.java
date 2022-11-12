package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exceptions.BadRequest;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    List< Question> questions;

    @BeforeEach
    public void init() {
         questions = new ArrayList<>(
                 List.of(
                         new Question("Вопрос №1", "Ответ №1"),
                         new Question("Вопрос №2", "Ответ №2"),
                         new Question("Вопрос №3", "Ответ №3"),
                         new Question("Вопрос №4", "Ответ №4"),
                         new Question("Вопрос №5", "Ответ №5"),
                         new Question("Вопрос №6", "Ответ №6"),
                         new Question("Вопрос №7", "Ответ №7"),
                         new Question("Вопрос №A", "Ответ №A"),
                         new Question("Вопрос №B", "Ответ №B"),
                         new Question("Вопрос №C", "Ответ №C")
                 )
         );
        when(questionServiceMock.getAll()).thenReturn(questions);
    }

    @Test
    void getQuestions() {
        Assertions.assertThrows(BadRequest.class, ()->examinerService.getQuestions(15));
        assertThat(examinerService.getQuestions(3).size()).isEqualTo(3);
        assertThat(examinerService.getQuestions(questions.size())).containsExactlyInAnyOrderElementsOf(questions);
    }
}