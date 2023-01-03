package com.example.studentmanagement.repositories;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component                  //inizierbar componentwherever DBZugriffStudent is called this class will be called with it as it is noted as a component
public class DbZugriffStudentenJPA implements DbZugriffStudenten{


    private StudentJPARepo studentJPARepo;


    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        return this.studentJPARepo.save(student);

    }

    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        Optional<Student> optStudent=this.studentJPARepo.findById(id);
        if (optStudent.isPresent()) {
            return optStudent.get();
        }else{
            throw new StudentNichtGefunden("Student mit der ID: "+ id + "nicht gefunden");
        }

    }

    @Override
    public void studentLoeschenMitId(Long id) {
        this.studentJPARepo.deleteById(id);
    }
}
