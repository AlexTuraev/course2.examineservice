package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.domain.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);
    Question add (Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    //Question getRandomQuestion();

//    @Override
    /*
        Чтобы не увеличивать кол-во бесполезных вызовов в ExaminerServiceImpl,
        решил предложить сделать метод статическим и передавать в него копию списка вопросов questions.
        В цикле while в ExaminerServiceImpl случайно выбранный вопрос удаляем из этого списка.
        Таким образом мы избегаем лишних итераций, когда "случайный" номер от Random будет повторяться.
        Это критично, когда размер списка вопросов и кол-во необходимых уникальных вопросов близки друг к другу.
        При amount < questions.size() кол-во итераций всегда будет равно amount и не больше. В противном случае кол-во итераций >= amount, чаще больше.
    * */
    public static Question getRandomQuestion(List <Question> questions) {
        java.util.Random random = new java.util.Random();
        int number = random.nextInt(questions.size());
        return questions.get(number);
    }
}