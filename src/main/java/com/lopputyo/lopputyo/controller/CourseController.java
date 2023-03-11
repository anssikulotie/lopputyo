package com.lopputyo.lopputyo.controller;
//Lisätään tarvittavat importit
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lopputyo.lopputyo.data.Course;
import com.lopputyo.lopputyo.service.CourseService;

//Määritetään luokka CourseController
@RestController
public class CourseController {
//Lisätään tarvittavat annotaatiot
    @Autowired
    private CourseService courseService;


//Määritetään endpoint kaikkien kurssien hakemiseksi
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
//Määritetään endpoint kurssin hakemiseksi ID:n perusteella
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//Määritetään endpoint kurssin lisäämiseksi
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

}
