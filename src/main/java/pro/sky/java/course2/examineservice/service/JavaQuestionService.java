package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService{
    private List<Question> questions; // хранилище

    public JavaQuestionService() {

        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (!questions.contains(newQuestion)) {
            questions.add(newQuestion);
            return newQuestion;
        } else {
            return null;
        }
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(new Question(question.getQuestion(), question.getAnswer()));
            return question;
        }else {
            return null;
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().collect(Collectors.toList());
    }

    public void removeAll() {
        questions.clear();
    }

    /*@Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        int number = random.nextInt(questions.size());
        return questions.get(number);
    }*/
}
