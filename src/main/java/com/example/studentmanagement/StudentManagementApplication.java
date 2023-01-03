package com.example.studentmanagement;

import com.example.studentmanagement.domain.Student;
import com.example.studentmanagement.repositories.DbZugriffStudenten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
public class StudentManagementApplication implements ApplicationRunner {

    //@Autowired                          //Dependency injection: Springboot searches for the path autmatically to find the correct implementation and injects the right object
    //StudentJPARepo studentJPARepo;
    @Autowired
    DbZugriffStudenten dbZugriffStudenten;

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hey SpringBoot!");
        this.dbZugriffStudenten.studentSpeichern (new Student("Sonja Lechner", "6060"));
        this.dbZugriffStudenten.studentSpeichern (new Student("Penny Lechner", "6060"));
        this.dbZugriffStudenten.studentSpeichern (new Student("Susie Lechner", "6060"));
        this.dbZugriffStudenten.studentSpeichern (new Student("Josan Lechner", "6060"));
        this.dbZugriffStudenten.studentSpeichern (new Student("Jason Lechner", "6060"));
    }
}
