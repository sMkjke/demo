package homework;

import java.util.Scanner;

public class Parser {

    final static Scanner scanner = new Scanner(System.in);

    static Command parseInput() {
        String input;
        Command command = null;
        while (command == null) {
            try {
                input = scanner.nextLine().toUpperCase();
                command = Command.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Введите верное направление (U,D,R,L) либо EXIT: ");
            }
        }

        return command;
    }
}