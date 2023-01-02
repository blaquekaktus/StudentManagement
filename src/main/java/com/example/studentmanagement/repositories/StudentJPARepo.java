package com.example.studentmanagement.repositories;

import com.example.studentmanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJPARepo extends JpaRepository <Student, Long>{
    List<Student> findAllByPlz(String plz);
    List<Student> findStudentById(Long id);




}
