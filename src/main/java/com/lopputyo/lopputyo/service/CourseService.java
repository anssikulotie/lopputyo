package com.lopputyo.lopputyo.service;

//Lisätään tarvittavat importit
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.Course;
//Määritetään luokka CourseService ja lisätään tarvittavat annotaatiot
@Service
public class CourseService {
    private List<Course> courses;

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
        return null;
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
    
    public Course getCourseById(String id) {
        for (Course course : courses) {
            if (course.getName().equals(id)) {
                return course;
            }
        }
        return null;
    }
}