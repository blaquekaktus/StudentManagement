package com.example.studentmanagement.controller;

import com.example.studentmanagement.exceptions.ExceptionDTO;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import com.example.studentmanagement.exceptions.StudentValidierungFehlgeschlagen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentNichtGefunden.class)
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden){
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidierungFehlgeschlagen.class)
    public ResponseEntity<ExceptionDTO>studentValidierungFehlgeschlagen(StudentValidierungFehlgeschlagen studentValidierungFehlgeschlagen){
        return new ResponseEntity<>(new ExceptionDTO("9000", studentValidierungFehlgeschlagen.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
