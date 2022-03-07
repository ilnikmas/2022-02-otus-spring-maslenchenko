package ru.otus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Quiz {
    private String question;
    private List<String> answers;

    public Quiz(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\nAnswers: " + answers;
    }
}
