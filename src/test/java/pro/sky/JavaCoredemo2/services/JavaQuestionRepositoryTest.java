package pro.sky.JavaCoredemo2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pro.sky.JavaCoredemo2.repository.JavaQuestionRepository;
import pro.sky.JavaCoredemo2.entity.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    private JavaQuestionRepository javaQuestionRepository;

    @BeforeEach
    public void testEach() {
        javaQuestionRepository = new JavaQuestionRepository();
    }
        @Test
        public void testAdd () {
            javaQuestionRepository.add("q1", "a1");
            javaQuestionRepository.add("q2", "a2");
            javaQuestionRepository.add(new Question("q3", "a3"));

            Assertions.assertThat(javaQuestionRepository.getAll())
                    .containsExactly(
                            new Question("q1", "a1"),
                            new Question("q2", "a2"),
                            new Question("q3", "a3"));
        }
        @Test
        void testGetAllCopy () {
            assertThrows(UnsupportedOperationException.class, () -> javaQuestionRepository.getAll().add(new Question("q1", "a1")));
        }
        @Test
        void testRemove () {
            javaQuestionRepository.add(new Question("q1", "a1"));
            Assertions.assertThat(javaQuestionRepository.remove(new Question("not_exist_q", "not_exist_a"))).isNull();
            Assertions.assertThat(javaQuestionRepository.remove(new Question("q1", "a1"))).isEqualTo(new Question("q1", "a1"));
        }

}