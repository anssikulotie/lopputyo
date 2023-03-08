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

  
  //Määritetään luokka Person
public class Person {

    //Määritetään muuttujat ja näkyvyys
    private String name;
    private int age;
    private int id;

    //Määritetään konstruktori
    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //Määritetään getterit ja setterit
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
}