package com.lopputyo.lopputyo.service;
//Lisätään tarvittavat importit
import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



//Määritetään luokka PersonService
@Service
public class PersonService {
    private List<Person> people;
//Määritetään konstruktori
public PersonService() {
    this.people = new ArrayList<>();
}
//Määritetään metodit getAllPeople, getPersonByName, addPerson, updatePerson, deletePerson ja getPersonById

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
//Määritetään virheilmoitus jos henkilö on jo olemassa
public ResponseEntity<String> addPerson(Person person) {
    if (getPersonByName(person.getName()) != null) {
        return new ResponseEntity<>("Person with that name already exists", HttpStatus.BAD_REQUEST);
    }
//Määritetään ilmoitus jos henkilö on lisätty onnistuneesti
    people.add(person);
    return new ResponseEntity<>("Person added successfully", HttpStatus.CREATED);
}
//Määritetään virheilmoitus jos henkilöä ei löydy
public ResponseEntity<String> updatePerson(int id, Person updatedPerson) {
    Person person = getPersonById(id);
    if (person == null) {
        return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
    }
//Määritetään ilmoitus jos henkilö on päivitetty onnistuneesti
    person.setName(updatedPerson.getName());
    person.setAge(updatedPerson.getAge());
    person.setId(updatedPerson.getId());
    return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
}
//Määritetään virheilmoitus jos henkilöä ei löydy
public ResponseEntity<String> deletePerson(int id) {
    Person person = getPersonById(id);
    if (person == null) {
        return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
    }
//Määritetään ilmoitus jos henkilö on poistettu onnistuneesti

    people.remove(person);
    return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
}

public Person getPersonById(int id) {
    for (Person person : people) {
        if (person.getId() == id) {
            return person;
        }
    }
    return null;
}
}