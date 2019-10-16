package com.example.and_130;

public class Persone {
    private int Age;
    private String Fio;

    @Override
    public String toString() {
        return  "ФИО: "+ Fio + " возраст: " + Age;
    }

    public String getFio() {
        return Fio;
    }

    public int getAge() {
        return Age;
    }


    public Persone(int age, String fio) {
        Age = age;
        Fio = fio;
    }
}
