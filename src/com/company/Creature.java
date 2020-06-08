package com.company;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature {
    private Position pos;
    private boolean live = true;
    private int health;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void die() {
        this.live = false;
    }


    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}
