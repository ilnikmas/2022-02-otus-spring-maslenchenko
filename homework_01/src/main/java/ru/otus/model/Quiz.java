package ru.otus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Quiz {
    private String question;
    private List<String> answers;
    private int correctAnswer;

    public Quiz(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Quiz() {

    }

//    @Override
//    public String toString() {
//        return "Question: " + question + "\nAnswers: " + answers;
//    }
}
