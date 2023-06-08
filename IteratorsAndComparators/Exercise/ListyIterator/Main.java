package Advance.IteratorsAndComparators.Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator listyIterator = null;

        while (!"END".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            switch (command) {
                case "Create":
                    if (commandParts.length > 1) {
                        String[] items = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                        listyIterator = new ListyIterator(items);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;

                case "Move":
                    System.out.println(listyIterator.Move());

                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.HasNext());
                    break;

                case "Print":
                    try {
                        System.out.println(listyIterator.Print());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
            }

            input = scanner.nextLine();
        }
    }
}
