package com.lopputyo.lopputyo.controller;
// Lisätään tarvittavat importit

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.lopputyo.lopputyo.data.Person;
import com.lopputyo.lopputyo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




// Määritetään luokka PersonController ja lisätään tarvittavat annotaatiot
@RestController
public class PersonController {

    @Autowired  
    private PersonService personService; 

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex) {
        //Määritetään virheen käsittely
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorMessage = "An unexpected error occurred";
        return new ResponseEntity<>(errorMessage, status);
    }




    //Määritetään endpoint henkilön lisäämiseksi
    @PostMapping("/person")
    public String addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return "Person added";
    }

    // Määritetään endpoint kaikkien henkilöiden hakemiseksi
    @GetMapping("/person")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // Määritetään endpoint henkilön hakemiseksi ID:n perusteella
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    // Määritetään endpoint henkilön päivittämiseksi
    @PutMapping("/person/{id}")
    public String updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        personService.updatePerson(id, person);
        return "data updated";
        
    }

    // Määritetään endpoint henkilön poistamiseksi
    @DeleteMapping ("/person/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return "Person is deleted";
    }
}