package pro.sky.JavaCoredemo2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.repository.MathQuestionsRepository;
import pro.sky.JavaCoredemo2.services.JavaQuestionService;
import pro.sky.JavaCoredemo2.services.QuestionService;

import java.util.List;
@ExtendWith(MockitoExtension.class)
public class MathQuestionsServiceTest {
    private QuestionService questionService;
    private MathQuestionsRepository mathQuestionsRepository;
    @BeforeEach
    public void testEach() {
        mathQuestionsRepository = Mockito.mock(MathQuestionsRepository.class);
        questionService = new JavaQuestionService(mathQuestionsRepository);
    }
    @Test
    void testGetRandomQuestionWhenAny () {
        List<Question> question = List.of(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3")
        );
        Mockito.when(mathQuestionsRepository.getAll()).thenReturn(question);

        Assertions.assertThat(questionService.getRandomQuestion()).isIn(question);
    }
}
