package homework.entity;

import homework.Navigable;

public class Cursor implements Navigable {

    private int x;
    private int y;

    public Cursor() {
        this.x = 0;
        this.y = 0;
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

    public void moveUp() {
        this.x = ((x == 0) ? Board.BOARD_SIZE - 1 : (x - 1));
    }

    public void moveDown() {
        this.x = ((x == Board.BOARD_SIZE - 1) ? 0 : (x + 1));
    }

    public void moveRight() {
        this.y = ((y == Board.BOARD_SIZE - 1) ? 0 : (y + 1));
    }

    public void moveLeft() {
        this.y = ((y == 0) ? Board.BOARD_SIZE - 1 : (y - 1));
    }

    @Override
    public void move(Command command) {
        switch (command) {
            case U -> moveUp();
            case D -> moveDown();
            case R -> moveRight();
            case L -> moveLeft();
        }
    }
}