package com.example.studentmanagement.repositories;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import org.springframework.stereotype.Component;

import java.util.List;

@Component                  //inizierbar componentwherever DBZugriffStudent is called this class will be called with it as it is noted as a component
public class DbZugriffStudentenJPA implements DbZugriffStudenten{


    private StudentJPARepo studentJPARepo;


    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeicher(Student student) {
        return null;
    }

    @Override
    public List<Student> alleStudenten() {
        return null;
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return null;
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        return null;
    }

    @Override
    public void studentLoeschenMitId(Long Id) {

    }
}
