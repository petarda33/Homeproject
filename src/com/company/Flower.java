package com.company;

public class Flower extends Creature{

    private String color = "green";
    private int age;

    public Flower (boolean epicFlower) {
        if (epicFlower == true) {
            setHealth(18);
        } else {
            setHealth(12);
        }
    }

    public void healthLessThan0 (Flower i) {
        if (i.getHealth() <= 0) {
            setHealth(0);
        }
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
