package com.lopputyo.lopputyo.data;

// Määritetään luokka Person, joka perii luokan Participant
public class Person extends Participant {
    // Määritetään konstruktori ja kutsutaan yliluokan konstruktoria
    public Person(String name, int age, int id) {
        super(name, age, id);
    }
    
}