package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Creature {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPos() {
        String xy = String.valueOf(this.x) + String.valueOf(this.y);
        return xy;
    }
}
