package pro.sky.JavaCoredemo2.services;

import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.exceptions.NotEnoughQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();

    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        }

        @Override
        public Collection<Question> getQuestions(int amount) {
            Collection<Question> allJavaQuestions = javaQuestionService.getAll();
            Collection<Question> allMathQuestions = mathQuestionService.getAll();
            if (allMathQuestions.size() + allMathQuestions.size() < amount) {
                throw new NotEnoughQuestionsException();
            }
            if (allMathQuestions.size() + allMathQuestions.size() == amount) {
                Set<Question> all = new HashSet<>(amount);
                all.addAll(allJavaQuestions);
                all.addAll(allMathQuestions);
                return all;
            }
            Set<Question> result = new HashSet<>(amount);
            while (result.size() != amount) {
                Question question = random.nextBoolean()
                        ? javaQuestionService.getRandomQuestion()
                        : mathQuestionService.getRandomQuestion();
                result.add(question);
            }
            return result;
        }
    }
