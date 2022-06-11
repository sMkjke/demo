package homework.entity;

import homework.entity.Command;

import java.util.Scanner;

/**
 * The type Parser.
 */
public class Parser {

    /**
     * The constant scanner.
     */
    final static Scanner scanner = new Scanner(System.in);

    /**
     * Parse user input, if input is correct - return command or catch IllegalArgumentException
     *
     * @return the command which user input
     */
    protected Command parseInput() {
        String input;
        Command command = null;
        while (command == null) {
            System.out.println("Введите направление (U,D,R,L) либо EXIT:");
            try {
                input = scanner.nextLine().toUpperCase();
                command = Command.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильная команда, повторите ввод");
            }
        }
        return command;
    }
}