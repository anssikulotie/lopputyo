package com.lopputyo.lopputyo.service;
//Lisätään tarvittavat importit
import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.Person;
import java.util.ArrayList;
import java.util.List;
//Määritetään luokka PersonService ja lisätään tarvittavat annotaatiot
@Service
public class PersonService {
    private List<Person> people;

    public PersonService() {
        this.people = new ArrayList<>();
    }
//Määritetään metodit getAllPeople, getPersonByName, addPerson, updatePerson ja deletePerson
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

    public void addPerson(Person person) {
        if (getPersonByName(person.getName()) == null) {
            people.add(person);
        }
    }

    public void updatePerson(int id, Person updatedPerson) {
        Person person = getPersonById(id);
        if (person != null) {
            person.setName(updatedPerson.getName());
            person.setAge(updatedPerson.getAge());
            person.setId(updatedPerson.getId());
        }
    }

    public void deletePerson(int id) {
        Person person = getPersonById(id);
        if (person != null) {
            people.remove(person);
        }
    }
//Määritetään metodi getPersonById
    public Person getPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
