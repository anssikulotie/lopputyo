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
import com.lopputyo.lopputyo.PersonService;
import com.lopputyo.lopputyo.CourseService;

//Määritetään Main-luokka
public class Main {
    public static void main(String[] args) {
        //Määritetään muuttujat ja näkyvyys
        PersonService personService = new PersonService();
        CourseService courseService = new CourseService();
//Määritetään uudet henkilöt ja lisätään ne personServiceen
        Person Maija = new Person("Matti", 25, 1);
        Person Matti = new Person("Maija", 30, 2);
        Person Pasi = new Person("Pasi", 40, 3);
        personService.addPerson(Matti);
        personService.addPerson(Maija);
        personService.addPerson(Pasi);
//Määritetään uudet kurssit ja lisätään ne courseServiceen
        Course mathCourse = new Course("Matematiikka");
        mathCourse.addStudent(Maija);
        courseService.addCourse(mathCourse);

        Course physicsCourse = new Course("Fysiikka");
        physicsCourse.addStudent(Matti);
        courseService.addCourse(physicsCourse);
        Course historyCourse = new Course("Historia");
        historyCourse.addStudent(Pasi);
        courseService.addCourse(historyCourse);
    }
}
