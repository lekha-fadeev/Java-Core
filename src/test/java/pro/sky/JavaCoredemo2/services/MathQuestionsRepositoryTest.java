package pro.sky.JavaCoredemo2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pro.sky.JavaCoredemo2.repository.MathQuestionsRepository;
import pro.sky.JavaCoredemo2.entity.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionsRepositoryTest {

    private MathQuestionsRepository mathQuestionsRepository;

    @BeforeEach
    public void testEach() {
        mathQuestionsRepository = new MathQuestionsRepository();
    }
    @Test
    public void testAdd () {
        mathQuestionsRepository.add("q1", "a1");
        mathQuestionsRepository.add("q2", "a2");
        mathQuestionsRepository.add(new Question("q3", "a3"));

        Assertions.assertThat(mathQuestionsRepository.getAll())
                .containsExactly(
                        new Question("q1", "a1"),
                        new Question("q2", "a2"),
                        new Question("q3", "a3"));
    }
    @Test
    void testGetAllCopy () {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionsRepository.getAll().add(new Question("q1", "a1")));
    }
    @Test
    void testRemove () {
        mathQuestionsRepository.add(new Question("q1", "a1"));
        Assertions.assertThat(mathQuestionsRepository.remove(new Question("not_exist_q", "not_exist_a"))).isNull();
        Assertions.assertThat(mathQuestionsRepository.remove(new Question("q1", "a1"))).isEqualTo(new Question("q1", "a1"));
    }

}
