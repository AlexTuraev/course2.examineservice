package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService{

    Set<Question> questions; // хранилище

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        if (questions.add(new Question(question, answer))) {
            return new Question(question, answer); // чтобы не передать ссылку на объект и впоследствии не дать к нему несанкционировнный доступ
        } else {
            return null;
        }
    }

    @Override
    public Question add(Question question) {
        if (questions.add(new Question(question.getQuestion(), question.getAnswer()))) {
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

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        int number = random.nextInt(questions.size());
        Question[] questionsArray = questions.toArray(new Question[0]);
        return questionsArray[number];
    }
}
