package ru.otus.dao;

import ru.otus.model.Quiz;

import java.util.List;

public interface QuizDao {
    List<Quiz> getQuestions();
}
