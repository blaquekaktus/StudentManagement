package com.example.studentmanagement.service;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;

import java.util.List;

public interface StudentenService {

    List<Student> alleStudenten();
    Student studentEinfuegen(Student student);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    List<Student> alleStundentenMItPlz(String plz);
    void studentMitIdLoeschen(Long id);

}
