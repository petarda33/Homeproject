package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Gardener extends Creature {
    public Gardener () {
        int posX = 0;
        int posY = 0;
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        switch (randomNum) {
            case 1 :
                posX = 0;
                posY = 7;
                break;
            case 2 :
                posX = 7;
                posY = 7;
                break;
            case 3 :
                posX = 7;
                posY = 0;
                break;
            default :
                posX = 0;
                posY = 0;
                break;
        }
        super.setX(posX);
        super.setY(posY);
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

    public void move() {
        int posX = getX();
        int posY = getY();
        int newX;
        int newY;

        inputloop: while(true) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
            switch (randomNum) {
                case 1:
                    if (posX < 7) {
                        newX = posX + 1;
                        newY = posY;
                        break inputloop;
                    }
                    break;
                case 2 :
                    if (posY < 7) {
                        newX = posX;
                        newY = posY + 1;
                        break inputloop;
                    }
                    break;
                case 3 :
                    if (posX > 0) {
                        newX = posX - 1;
                        newY = posY;
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

    public void killInsect(Insect i) {
        i.die();
    }
}
