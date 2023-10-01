package pro.sky.JavaCoredemo2.services;

import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.exceptions.NoQuestionsException;
import pro.sky.JavaCoredemo2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();

    private final QuestionRepository repository;

    public MathQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var questions = repository.getAll();
        if (questions.isEmpty()) {
            throw new NoQuestionsException();
        }
        var index = random.nextInt(questions.size());
        var it = questions.iterator();
        int i = 0;
        while (it.hasNext()) {
            Question q = it.next();
            if (i == index) {
                return q;
            }
            i++;
            }
            return null;
        }
    }
