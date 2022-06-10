package homework.entity;

import homework.utils.Parser;

public class Board {

    public final static int BOARD_SIZE = 10;

    final Cursor cursor;

    public Board() {
        this.cursor = new Cursor();
    }

    public void startGame() {
        while (true) {
            printBoard(cursor); //Draw initial board
            Command command = Parser.parseInput(); //Try to parse User input
            if (command == Command.EXIT) {
                System.out.println("Bye!");
                break;
            } else {
                cursor.move(command);
            }
        }
    }

    private static void printBoard(final Cursor cursor) { //print a board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                if (i == cursor.getX() && k == cursor.getY()) {
                    System.out.print("O" + " ");
                } else {
                    System.out.print("X" + " ");
                }
            }
            System.out.println();
        }
    }
}