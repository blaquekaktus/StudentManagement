package com.example.studentmanagement.controller;


import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.exceptions.StudentNichtGefunden;
import com.example.studentmanagement.exceptions.StudentValidierungFehlgeschlagen;
import com.example.studentmanagement.service.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public ResponseEntity<Student> studentEinfuegen (@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen {
       String errors = "";
       if(bindingResult.hasErrors()){
           for(ObjectError error : bindingResult.getAllErrors()){
               errors += "\nValidierungsfehler für Objekt " + error.getObjectName() + " im Feld "
                       + ((FieldError)error).getField() + "mit folgendem Problem: " + error.getDefaultMessage();
           }
           throw new StudentValidierungFehlgeschlagen(errors);
       }else{
           return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
       }
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String studentloeschen(@PathVariable Long id){
        this.studentenService.studentMitIdLoeschen(id);
        return "Student gelöscht!";
    }

    @GetMapping("/mitplz/{plz}")

    public ResponseEntity<List<Student>>alleStudentenMitPlz(@PathVariable String plz){
        return ResponseEntity.ok(this.studentenService.alleStundentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>studentMitId(@PathVariable Long id) throws StudentNichtGefunden    {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }



}
