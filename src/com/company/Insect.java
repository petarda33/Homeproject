package com.company;

import java.util.concurrent.Flow;
import java.util.concurrent.ThreadLocalRandom;

public class Insect extends Creature{

    public boolean canAttack = true;

    public Insect() {
        setHealth(6);
    }

    public void move() {
        int posX = this.getPos().getX();
        int posY = this.getPos().getY();
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

        this.getPos().setX(newX);
        this.getPos().setY(newY);


    }

    public void eatFlower (Flower i, Gardener j) {
        int newHealth;
        if (this.getPos().equals(i.getPos()) && !this.getPos().equals(j.getPos())) {
            int healthLoss = 2;
            newHealth = i.getHealth() - healthLoss;
            i.setHealth(newHealth);
            System.out.println("Ezen a koordinátán (" + i.getPos() + ") lévő növény élete :" + i.getHealth());
        }
    }




}
