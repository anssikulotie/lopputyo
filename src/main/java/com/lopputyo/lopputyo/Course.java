package com.lopputyo.lopputyo;
//Lisätään tarvittavat importit

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lopputyo.lopputyo.Person;
import com.lopputyo.lopputyo.Course;


//Määritetään luokka Course
public class Course {

    //Määritetään muuttujat ja näkyvyys
    private String name;
    private List<Person> students;
 

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
//Määritetään getterit ja setterit
    public String getName() {
        return name;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }
//Määritetään metodit addStudent ja removeStudent
    public void addStudent(Person student) {
        this.students.add(student);
    }

    public void removeStudent(Person student) {
        this.students.remove(student);
    }
}