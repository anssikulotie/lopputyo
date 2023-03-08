package com.lopputyo.lopputyo;
// Lisätään tarvittavat importit

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.lopputyo.lopputyo.Person;
import com.lopputyo.lopputyo.PersonService;


// Määritetään luokka PersonController
@RestController
public class PersonController {
    @Autowired  
    


    // Luodaan uusi PersonService-olio
    private PersonService personService = new PersonService();

    //Määritetään endpoint henkilön lisäämiseksi
    @PostMapping("/person")
    public String addPerson(@RequestParam Person person) {
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
    public Person updatePerson(@PathVariable("id") int id, @RequestParam Person person) {
        personService.updatePerson(id, person);
        return "data updated";
        
    }

    // Määritetään endpoint henkilön poistamiseksi
    @DeleteMapping ("/person/{id}")
    public Person deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return "Person is deleted";
    }
}