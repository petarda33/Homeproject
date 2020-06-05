package com.company;

import java.util.concurrent.Flow;
import java.util.concurrent.ThreadLocalRandom;

public class Insect extends Creature{

    public int energy = 6;
    public boolean isAlive = true;
    public boolean canAttack = true;

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

    public void die() {
        this.isAlive = false;
    }

    public boolean death() {
        if (energy == 0) {
           return isAlive = false;
        }
        return true;
    }

    public void move() {
        int posX = getX();
        int posY = getY();
        int newX;
        int newY;

        inputloop:
        while (true) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 8);
            switch (randomNum) {
                case 1:
                    if (posX < 7) {
                        newX = posX + 1;
                        newY = posY;
                        break inputloop;
                    }
                    break;
                case 2:
                    if (posY < 7) {
                        newX = posX;
                        newY = posY + 1;
                        break inputloop;
                    }
                    break;
                case 3:
                    if (posX > 0) {
                        newX = posX - 1;
                        newY = posY;
                        break inputloop;
                    }
                    break;
                case 4:
                    if (posX < 7 && posY < 7) {
                        newX = posX + 1;
                        newY = posY + 1;
                        break inputloop;
                    }
                    break;
                case 5:
                    if (posX > 0 && posY > 0) {
                        newX = posX - 1;
                        newY = posY - 1;
                        break inputloop;
                    }
                    break;
                case 6 :
                    if (posX < 7 && posY > 0) {
                        newX = posX + 1;
                        newY = posX - 1;
                        break inputloop;
                    }
                    break;
                case 7 :
                    if (posX > 0 && posY < 7) {
                        newX = posX - 1;
                        newY = posY + 1;
                        break inputloop;
                    }
                    break;
                default:
                    if (posY > 0) {
                        newX = posX;
                        newY = posY - 1;
                        break inputloop;
                    }
                    break;
            }
        }

        super.setX(newX);
        super.setY(newY);


    }

    public void eatFlower (Flower i, Gardener j) {
        int newHealth;
        if (this.getPos().equals(i.getPos()) && !this.getPos().equals(j.getPos())) {
            newHealth = i.getHealth() - 2;
            System.out.println(newHealth);
        }
    }




}
