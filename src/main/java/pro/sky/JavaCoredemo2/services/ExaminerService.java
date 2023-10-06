package pro.sky.JavaCoredemo2.services;

import pro.sky.JavaCoredemo2.entity.Question;

import java.util.Collection;


public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
