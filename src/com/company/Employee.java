package com.company;

import java.time.LocalDate;

public class Employee {
    //TODO: de sters
    //TODO: de adaugat surname/birthdate
    private String name;
    private String surname;
    private LocalDate birthdate;
    // surname birthdate

    // getter + setter


    public Employee(String name, String surname, LocalDate birthdate) {
            this.name = name;
            this.surname = surname;
            this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}