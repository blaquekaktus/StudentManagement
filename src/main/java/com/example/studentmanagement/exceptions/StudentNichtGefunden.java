package com.example.studentmanagement.exceptions;

public class StudentNichtGefunden extends Exception {
    public StudentNichtGefunden(String message) {
        super("Student nicht gefunden!");
    }
}
