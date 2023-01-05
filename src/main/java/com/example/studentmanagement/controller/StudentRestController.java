package com.example.studentmanagement.controller;


import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import com.example.studentmanagement.service.StudentenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studenten")
public class StudentRestController {

    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }
    @GetMapping
    public ResponseEntity<List<Student>>gibAlleStudenten(){
        return ResponseEntity.ok(this.studentenService.alleStudenten());
    }

    @PostMapping
    public ResponseEntity<Student> studentEinfuegen (@RequestBody Student student){
       return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
    }
    @DeleteMapping("/{id}")
    public String studentloeschen(@PathVariable Long id){
        this.studentenService.studentMitIdLoeschen(id);
        return "Student gelöscht!";
    }

    @GetMapping("/mitplz/{plz}")

    public ResponseEntity<List<Student>>allStudentenMitPly  (String plz){
        return ResponseEntity.ok(this.studentenService.alleStundentenMItPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>studentMitId(Long id) throws StudentNichtGefunden    {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }



}
