package com.example.studentmanagement.repositories;


import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;

import java.util.List;

public interface DbZugriffStudenten {
    Student studentSpeichern(Student student);
    List<Student> alleStudenten();
    List<Student> alleStudentenAusDemOrt(String plz);
    Student studentMitId(Long id) throws StudentNichtGefunden;
    void studentLoeschenMitId(Long Id);

}
