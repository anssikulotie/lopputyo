package com.lopputyo.lopputyo.data;
//Lisätään tarvittavat importit

import java.util.ArrayList;
import java.util.List;


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