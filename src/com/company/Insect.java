package com.company;

import java.util.Random;
import java.math.*;
import java.util.concurrent.Flow;
import java.util.concurrent.ThreadLocalRandom;

public class Insect extends Creature {

    public boolean canAttack = true;

    public Insect() {
        setHealth(6);
    }

    public void move() {
        int posX = this.getPos().getX();
        int posY = this.getPos().getY();
        int newX;
        int newY;


        //   inputloop:
        Position position = this.getPos();
        int randomNum = new Random().nextInt(8);
        switch (randomNum) {
            case 1:
                position.moveUp();
                    /*if (posX < 7) {
                        newX = posX + 1;
                        newY = posY;
                        break inputloop;
                    } */
                break;
            case 2:
                position.moveDown();
                    /*if (posY < 7) {
                        newX = posX;
                        newY = posY + 1;
                        break inputloop;
                    }*/
                break;
            case 3:
                position.moveLeft();
                  /*  if (posX > 0) {
                        newX = posX - 1;
                        newY = posY;
                        break inputloop;
                    }*/
                break;
            case 4:
                position.moveRight();
                   /* if (posX < 7 && posY < 7) {
                        newX = posX + 1;
                        newY = posY + 1;
                        break inputloop;
                    }*/
                break;
            case 5:
                position.moveUpLeft();
                   /* if (posX > 0 && posY > 0) {
                        newX = posX - 1;
                        newY = posY - 1;
                        break inputloop;
                    }*/
                break;
            case 6:
                position.moveUpRight();
                  /*  if (posX < 7 && posY > 0) {
                        newX = posX + 1;
                        newY = posX - 1;
                        break inputloop;
                    }*/
                break;
            case 7:
                position.moveDownLeft();
                   /* if (posX > 0 && posY < 7) {
                        newX = posX - 1;
                        newY = posY + 1;
                        break inputloop;
                    }*/
                break;
            default:
                position.moveDownRight();
                  /*  if (posY > 0) {
                        newX = posX;
                        newY = posY - 1;
                        break inputloop;
                    }*/
                break;
        }


        //this.getPos().setX(newX);
        //this.getPos().setY(newY);


    }

    public void eatFlower(Flower f) {
        int newFlowerHealth;
        int newInsectHealth;
        newFlowerHealth = f.getHealth() - 2;
        newInsectHealth = this.getHealth() + 3;
        f.setHealth(Math.max(0,newFlowerHealth));

        // A rovar elete nem mehet 6 fole
        this.setHealth(Math.min(6, newInsectHealth));
        System.out.println("A rovar élete nőtt:" + this.getHealth() + "(pozíció: " + this.getPos() + ")");
        System.out.println("A növény élete csökkent" + f.getHealth() + "(pozíció: " + f.getPos() + ")");
        //System.out.println("Ezen a koordinátán (" + i.getPos() + ") lévő növény élete :" + i.getHealth());
    }


    public void insectHealthDown() {
        int newInsectHealth;
        newInsectHealth = this.getHealth() - 3;
        this.setHealth(Math.max(0,newInsectHealth));
    }

}
