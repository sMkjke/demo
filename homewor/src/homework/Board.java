package homework;

class Board {

    private int x = 0;
    private int y = 0;


    void moveChar() {
        boolean isWorks = true;
        while (isWorks) {
            int size = 10;
            print(size, x, y);
            Command command = Parser.parseInput();
            switch (command) {
                case U:
                    x = (x == 0) ? 9 : (x - 1);
                    break;
                case D:
                    x = (x == 9) ? 0 : (x + 1);
                    break;
                case R:
                    y = (y == 9) ? 0 : (y + 1);
                    break;
                case L:
                    y = (y == 0) ? 9 : (y - 1);
                    break;
                case EXIT:
                    isWorks = false;
                    break;
            }
        }
    }

    private static void print(int size, int x, int y) {
        for (int i = 1; i < size; i++) {
            for (int k = 1; k < size; k++) {
                if (i == x && k == y) {
                    System.out.print("O" + " ");
                } else {
                    System.out.print("X" + " ");
                }
            }
            System.out.println();
        }
    }
}