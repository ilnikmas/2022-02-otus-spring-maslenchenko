package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.config.ApplicationConfig;
import ru.otus.model.Quiz;
import ru.otus.model.Student;
import ru.otus.service.QuizRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        QuizRepository quizRepository = context.getBean(QuizRepository.class);
        Student student = new Student();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your name:");
            student.setFirstName(reader.readLine());
            System.out.println("Enter your last name:");
            student.setLastName(reader.readLine());
            List<Integer> answers = new ArrayList<>();
            for (Quiz quiz : quizRepository.getQuizList()) {
                System.out.println(quiz.getQuestion());
                System.out.println(quiz.getAnswers());
                answers.add(Integer.parseInt(reader.readLine()));
                student.setAnswers(answers);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
