package com.lopputyo.lopputyo;
//Lisätään tarvittavat importit
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;
import com.lopputyo.lopputyo.Person;


//Määritetään luokka PersonService
@Service
public class PersonService {
    private List<Person> people;
//Määritetään konstruktori
    public PersonService() {
        this.people = new ArrayList<>();
    }
//Määritetään metodit getAllPeople ja getPersonByName
    public List<Person> getAllPeople() {
        return people;
    }

    public Person getPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
//Määritetään metodit addPerson, updatePerson ja deletePerson
    @PostMapping("/people")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        if (getPersonByName(person.getName()) != null) {
            //Määritetään virheilmoitus
            return new ResponseEntity<>("Person with that name already exists", HttpStatus.BAD_REQUEST);
        }

        people.add(person);
        //Määritetään onnistumisilmoitus
        return new ResponseEntity<>("Person added successfully", HttpStatus.CREATED);
    }
//Määritetään metodit updatePerson ja deletePerson
    @PutMapping("/people/{name}")
    public ResponseEntity<String> updatePerson(@PathVariable String name, @RequestBody Person updatedPerson) {
        Person person = getPersonByName(name);
        if (person == null) {
            //Määritetään virheilmoitus
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }

        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        person.setId(updatedPerson.getId());
        //Määritetään onnistumisilmoitus
        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/people/{name}")
    public ResponseEntity<String> deletePerson(@PathVariable String name) {
        Person person = getPersonByName(name);
        if (person == null) {
            //Määritetään virheilmoitus
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }

        people.remove(person);
        //Määritetään onnistumisilmoitus
        return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
    }

}