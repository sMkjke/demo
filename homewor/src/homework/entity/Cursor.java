package homework.entity;

import homework.Navigable;

/**
 * The type Cursor.
 */
public class Cursor implements Navigable {

    private int x;
    private int y;

    /**
     * Instantiates a new Cursor with default x,y position.
     */
    public Cursor() {
        this.x = 0;
        this.y = 0;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void moveUp() {
        this.x = ((x == 0) ? Board.BOARD_SIZE - 1 : (x - 1));
    }

    private void moveDown() {
        this.x = ((x == Board.BOARD_SIZE - 1) ? 0 : (x + 1));
    }

    private void moveRight() {
        this.y = ((y == Board.BOARD_SIZE - 1) ? 0 : (y + 1));
    }

    private void moveLeft() {
        this.y = ((y == 0) ? Board.BOARD_SIZE - 1 : (y - 1));
    }

    /**
     * Implements interface method, uses Command to 
     * @param command the command
     */
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