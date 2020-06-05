package com.company;

public class Flower extends Creature{

    private String color = "green";
    private int age;
    private int health = 12;
    public boolean isAlive = true;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setX(int x) {
        super.setX(x);
    }

    public void setY(int y) {
        super.setY(y);
    }

    public String getPos() {
        return super.getPos();
    }

    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }

    public boolean death() {
        if (this.health == 0) {
            System.out.println("I'm dead! " + getPos());
        }
        return true;
    }



}
