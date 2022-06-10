package homework.utils;

import homework.entity.Command;

import java.util.Scanner;

public class Parser {

    final static Scanner scanner = new Scanner(System.in);

    public static Command parseInput() {
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