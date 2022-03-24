package ru.otus.service;

public interface IOService {
    void write(String text);
    String read();
    Integer readInt();
}
