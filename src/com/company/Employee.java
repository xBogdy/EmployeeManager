package com.company;

import java.util.Date;

public class Employee {
    // Fiecare angajat are acces la toate datele despre toti angajati
    //TODO: de sters
static String[] name = new String[100];
static String[] surname = new String[100];
static Date[] birthdate = new Date[100];
//localdate in loc
    //TODO: de adaugat surname/birthdate
    private String name1;
    private String surname1;
    // surname birthdate

    // getter + setter


    // TODO: de sters
    public Employee() {

    }
    public Employee(String nume,String prenume,int index) {
        name[index] = nume;
        surname[index] = prenume;
        this.name1 = nume;
    }
    public Employee(String nume, String prenume, Date bd, int index) {
        name[index] = nume;
        surname[index] = prenume;
        birthdate[index] = bd;
    }
    public static String getName(int index) { return name[index]; }

}