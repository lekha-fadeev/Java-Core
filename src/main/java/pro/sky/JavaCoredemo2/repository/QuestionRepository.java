package pro.sky.JavaCoredemo2.repository;

import pro.sky.JavaCoredemo2.entity.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
