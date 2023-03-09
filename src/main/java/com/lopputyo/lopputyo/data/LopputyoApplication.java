package com.lopputyo.lopputyo.data;
//Lisätään tarvittavat importit
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopputyo.lopputyo.service.CourseService;
import com.lopputyo.lopputyo.service.PersonService;

//Määritetään Main-luokka ja Spring Boot
@SpringBootApplication
public class LopputyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopputyoApplication.class, args);
	
        //Määritetään muuttujat ja näkyvyys
        PersonService personService = new PersonService();
        CourseService courseService = new CourseService();
//Määritetään uudet henkilöt ja lisätään ne personServiceen testikäyttöön
        Person Maija = new Person("Matti", 25, 1);
        Person Matti = new Person("Maija", 30, 2);
        Person Pasi = new Person("Pasi", 40, 3);
        personService.addPerson(Matti);
        personService.addPerson(Maija);
        personService.addPerson(Pasi);
//Määritetään uudet kurssit ja lisätään ne courseServiceen testikäyttöön
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


