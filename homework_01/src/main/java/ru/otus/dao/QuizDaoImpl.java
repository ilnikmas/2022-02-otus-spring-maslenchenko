package ru.otus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.model.Quiz;
import ru.otus.service.ResourceConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizDaoImpl implements QuizDao {
    private final static int QUESTION_POSITION = 0;
    private final static int CORRECT_ANSWER_POSITION = 4;

    private final ResourceConnection resourceConnection;

    @Autowired
    public QuizDaoImpl(ResourceConnection resourceConnection) {
        this.resourceConnection = resourceConnection;
    }

    @Override
    public List<Quiz> getQuestions() {
        List<Quiz> quizList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(resourceConnection.getResourceFile());
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                quizList.add(parseQuizString(line));
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return quizList;
    }

    private Quiz parseQuizString(String fileLine) {
        List<String> line = Arrays.asList(fileLine.split(","));
        String question = line.get(QUESTION_POSITION);
        List<String> answers = line.subList(1, line.size() - 2);
        int correctAnswer = Integer.parseInt(line.get(CORRECT_ANSWER_POSITION));
        return new Quiz(question, answers, correctAnswer);
    }
}
