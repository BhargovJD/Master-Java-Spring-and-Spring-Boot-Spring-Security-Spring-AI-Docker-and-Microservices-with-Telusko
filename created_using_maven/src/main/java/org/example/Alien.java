package org.example;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;

    private Laptop lap;

    public Alien(){
        System.out.println("Alien obj. created");
    }


    @ConstructorProperties({"age","lap"})
    public Alien(int age, Laptop lap) {
        this.age = age;
        this.lap = lap;
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void code(){
        System.out.println("Coding...");
        lap.compile();
    }
}
