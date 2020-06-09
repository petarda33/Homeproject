package com.company;

import java.util.Objects;

public class Position {
    int x;
    int y;

    public boolean moveUp() {
        if (this.y > 0) {
            this.y--;
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        if (this.y < 7) {
            this.y++;
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (this.x < 7) {
            this.x++;
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (this.x > 0) {
            this.x--;
            return true;
        }
        return false;
    }

    public boolean moveUpRight() {
        if (this.y > 0 && x < 7) {
            this.y--;
            this.x++;
            return true;
        }
        return false;
    }

    public boolean moveUpLeft() {
        if (this.y > 0 && x > 0) {
            this.y--;
            this.x--;
            return true;
        }
        return false;
    }

    public boolean moveDownLeft() {
        if (this.y < 7 && this.x > 0) {
            this.y++;
            this.x--;
            return true;
        }
        return false;
    }

    public boolean moveDownRight() {
        if (this.y < 7 && this.x < 7) {
            this.y++;
            this.x++;
            return true;
        }
        return false;
    }

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

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
