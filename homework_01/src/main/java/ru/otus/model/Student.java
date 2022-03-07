package ru.otus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private String firstName;
    private String lastName;
    private List<Integer> answers;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", answers=" + answers +
                '}';
    }
}
