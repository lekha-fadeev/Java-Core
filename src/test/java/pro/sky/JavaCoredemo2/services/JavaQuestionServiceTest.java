package pro.sky.JavaCoredemo2.services;

import org.junit.jupiter.api.Assertions;
import pro.sky.JavaCoredemo2.repository.MathQuestionsRepository;
import pro.sky.JavaCoredemo2.entity.Question;
import org.junit.jupiter.api.Test;
import pro.sky.JavaCoredemo2.exceptions.NoQuestionsException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    MathQuestionsRepository service = new MathQuestionsRepository();

@Test
    public void testAdd(){
    service.add("q1", "a1");
    service.add("q2", "a2");
    service.add(new Question("q3", "a3"));

    Assertions.assertThat(service.getAll())
            .containsExactly(
                    new Question("q1", "a1"),
                    new Question("q2", "a2"),
                    new Question("q3", "a3"));
}

void testGetAllCopy(){
    assertThrows(UnsupportedOperationException.class, () -> service.getAll().add(new Question("q1", "a1")));
}
    void  testRemove(){
    service.add(new Question("q1", "a1"));
    Assertions.assertThat(service.remove(new Question("not_exist_q", "not_exist_a"))).isNull();
    Assertions.assertThat(service.remove(new Question("q1", "a1"))).isEqualTo(new Question("q1", "a1"));
    }
    void testGetRandomQuestionWhenEmpty(){
    assertThrows(NoQuestionsException.class,() -> service.getRandomQuestion());
    }
    void testGetRandomQuestion(){
    service.add(new Question("q1", "a1"));
        Assertions.assertThat(service.getAll().size()).isEqualTo(1);
                Assertions.assertThat(service.GetRandomQuestion()).isEqualTo(new Question("q1", "a1"));
    }
    void testGetRandomQuestionWhenAny(){
        service.add("q1", "a1");
        service.add("q2", "a2");
        service.add("q3", "a3");

    var allQuestions =service.getAll();
    Set<Question> actualQuestions = new HashSet<>();
    while (actualQuestions.size()!=3){
        actualQuestions.add(service.getRandomQuestion());
    }
        Assertions.assertThat(allQuestions).isEqualTo(actualQuestions);
    }
}