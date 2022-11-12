package pro.sky.java.course2.examineservice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.domain.Question;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    void beforeActions() {
        //javaQuestionService.questions.clear();
        javaQuestionService.removeAll();

    }

    void addSomeInitialQuestions() {
        javaQuestionService.add("Вопрос1", "Ответ1");
        javaQuestionService.add("Вопрос2", "Ответ2");
        javaQuestionService.add("Вопрос3", "Ответ3");
        javaQuestionService.add("Вопрос4", "Ответ4");
        javaQuestionService.add("Вопрос5", "Ответ5");
    }

    @Test
    void add() {
        addSomeInitialQuestions();

        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос1", "Ответ1"))).isTrue();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос2", "Ответ2"))).isTrue();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос6", "Ответ6"))).isFalse();
    }

    @Test
    void testAdd() {
        javaQuestionService.add(new Question("Вопрос11", "Ответ11"));
        javaQuestionService.add(new Question("Вопрос12", "Ответ12"));
        javaQuestionService.add(new Question("Вопрос13", "Ответ13"));

        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос11", "Ответ11"))).isTrue();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос12", "Ответ12"))).isTrue();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос14", "Ответ14"))).isFalse();
    }

    @Test
    void remove() {
        addSomeInitialQuestions();
        javaQuestionService.remove(new Question("Вопрос1", "Ответ1"));
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос1", "Ответ1"))).isFalse();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос2", "Ответ2"))).isTrue();
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос3", "Ответ3"))).isTrue();

        javaQuestionService.remove(new Question("Вопрос2", "Ответ2"));
        assertThat(javaQuestionService.getAll().contains(new Question("Вопрос2", "Ответ2"))).isFalse();
    }

    @Test
    void getAll() {
        /*addSomeInitialQuestions();
        System.out.println(javaQuestionService.getAll());*/
    }

    @Test
    void getRandomQuestion() {
        /*addSomeInitialQuestions();
        System.out.println(javaQuestionService.getRandomQuestion());*/
    }
}