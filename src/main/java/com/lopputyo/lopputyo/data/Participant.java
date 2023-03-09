package com.lopputyo.lopputyo.data;

//Lisätään tarvittavat importit


//Määritetään luokka Participant
public class Participant {
    //Määritetään muuttujat ja näkyvyys
    private String name;
    private int age;
    private int id;

    //Määritetään konstruktori
    public Participant(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //Määritetään getterit ja setterit
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}