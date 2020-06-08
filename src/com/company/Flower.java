package com.company;

public class Flower extends Creature{

    private String color = "green";
    private int age;

    public Flower () {
        setHealth(12);

    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
