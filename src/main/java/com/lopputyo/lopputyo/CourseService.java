package com.lopputyo.lopputyo;

//Lisätään tarvittavat importit
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lopputyo.lopputyo.Course;

@Service
//Määritetään luokka CourseService
public class CourseService {
//Määritetään muuttuja courses ja näkyvyys
    private List<Course> courses;
//Määritetään konstruktori
    public CourseService() {
        this.courses = new ArrayList<>();
    }
//Määritetään metodit getAllCourses, getCourseByName, addCourse, updateCourse ja deleteCourse
    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        //Palautetaan poikkeus
        throw new CourseNotFoundException();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(String name, Course updatedCourse) {
        Course course = getCourseByName(name);
        if (course != null) {
            course.setName(updatedCourse.getName());
            course.getStudents().clear();
            course.getStudents().addAll(updatedCourse.getStudents());
        }
    }

    public void deleteCourse(String name) {
        Course course = getCourseByName(name);
        if (course != null) {
            courses.remove(course);
        }
    }
//Määritetään poikkeus CourseNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class CourseNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}
