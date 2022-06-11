package homework.entity;

/**
 * The type Board.
 */
public class Board {

    /**
     * The constant BOARD_SIZE.
     */
    public final static int BOARD_SIZE = 10;
    final Cursor cursor;
    final Parser parser;

    /**
     * Create new Cursor and Parser together with Board init
     */
    public Board() {
        this.cursor = new Cursor();
        this.parser = new Parser();
    }

    /**
     * Start game implements simple one-cursor game.
     */
    public void startGame() {
        while (true) {
            printBoard(cursor); //Draw initial board
            Command command = parser.parseInput();//parse User input
            if (command == Command.EXIT) {
                System.out.println("Bye!");
                break;
            } else {
                cursor.move(command);
            }
        }
    }

    /**
     * Represents on console view of board with one-cursor;
     * @param cursor
     */
    private void printBoard(final Cursor cursor) {
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