package com.example.studentmanagement.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor         //Creates a constructor with all the class Arguments
@NoArgsConstructor          //Creates a constructor with none of the class Arguments
@Getter                     //auto generates the getter methods
@Setter                     //auto generates the setter methods
                            // This is not recommended as the Business Logic may need to be implemented and the programmer needs to ensure this is done properly

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min=2, max=30)        //size constraint (valication dependency): name must be minimum 2 characters long
    private String name;

    @Size(min=4, max=6)         //size constraint (valication dependency): plz must be minimum 2 characters and maximum 6 characters long
    private  String plz;

    //constructor to create a student by giving the name and plz
    public Student(String name, String plz){
        this.name =  name;
        this.plz =  plz;
    }

}
