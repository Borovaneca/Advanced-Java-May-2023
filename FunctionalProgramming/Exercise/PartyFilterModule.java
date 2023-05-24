package Advance.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> filters = new HashMap<>();

        String input;
        while (!"Print".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(";");
            String currentCommand = tokens[0];
            String nameOfPredicate = tokens[1] + tokens[2];

            Predicate<String> current = null;
            if (currentCommand.equals("Add filter")) {

                if (tokens[1].equals("Starts with")) {
                    current = str -> str.startsWith(tokens[2]);
                } else if (tokens[1].equals("Ends with")) {
                    current = str -> str.endsWith(tokens[2]);
                } else if (tokens[1].equals("Length")) {
                    current = str -> str.length() == Integer.parseInt(tokens[2]);
                } else if (tokens[1].equals("Contains")) {
                    current = str -> str.contains(tokens[2]);
                }
                filters.putIfAbsent(nameOfPredicate, current);

            } else if (currentCommand.equals("Remove filter")) {
                filters.remove(nameOfPredicate);
            }
        }

        names.forEach(name -> {
            AtomicBoolean isPrintable = new AtomicBoolean(true);
            filters.forEach((k, v) -> {
                if (v.test(name)) {
                    isPrintable.set(false);
                }
            });
            if (isPrintable.get()) {
                System.out.print(name + " ");
            }
        });
    }
}
