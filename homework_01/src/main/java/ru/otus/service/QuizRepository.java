package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.model.Quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuizRepository {
    private List<Quiz> quizList;

    @Autowired
    public void setQuizList(ResourceConnection connection) {
        List<Quiz> quizList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(connection.getResourceFile());
                BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                quizList.add(getQuiz(line));
                line = reader.readLine();
            }
            this.quizList = quizList;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    private Quiz getQuiz(String fileLine) {
        List<String> line = Arrays.asList(fileLine.split(","));
        String question = line.get(0);
        List<String> answers = line.subList(1, line.size());
        return new Quiz(question, answers);
    }
}
