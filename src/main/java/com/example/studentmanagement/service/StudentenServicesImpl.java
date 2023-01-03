package com.example.studentmanagement.service;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import com.example.studentmanagement.repositories.DbZugriffStudenten;

import java.util.List;

public class StudentenServicesImpl implements StudentenService{

    private DbZugriffStudenten dbZugriffStudenten;

    public StudentenServicesImpl(DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffStudenten = dbZugriffStudenten;
    }

    @Override
    public List<Student> alleStudenten() {

        return this.dbZugriffStudenten.alleStudenten();
    }

    @Override
    public Student studentEinfuegen(Student student) {
        return this.dbZugriffStudenten.studentSpeichern(student);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        return this.dbZugriffStudenten.studentMitId(id);
    }

    @Override
    public List<Student> alleStundentenMItPlz(String plz) {
        return this.dbZugriffStudenten.alleStudentenAusDemOrt(plz);
    }

    @Override
    public void studentMitIdLoeschen(Long id) {
        this.dbZugriffStudenten.studentLoeschenMitId(id);
    }
}