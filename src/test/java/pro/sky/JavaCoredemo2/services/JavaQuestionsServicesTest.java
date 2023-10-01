package pro.sky.JavaCoredemo2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.JavaCoredemo2.entity.Question;
import pro.sky.JavaCoredemo2.repository.JavaQuestionRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionsServicesTest {

    private QuestionService questionService;
private JavaQuestionRepository javaQuestionRepository;
    @BeforeEach
    public void testEach() {
        javaQuestionRepository = Mockito.mock(JavaQuestionRepository.class);
        questionService = new JavaQuestionService(javaQuestionRepository);
    }
    @Test
    void testGetRandomQuestionWhenAny () {
        List<Question> question = List.of(
              new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3")
        );
Mockito.when(javaQuestionRepository.getAll()).thenReturn(question);

        Assertions.assertThat(questionService.getRandomQuestion()).isIn(question);
    }
}
