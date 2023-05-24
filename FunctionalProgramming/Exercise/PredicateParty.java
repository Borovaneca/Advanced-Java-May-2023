package Advance.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = scanner.nextLine()) && !names.isEmpty()) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String secondCommand = tokens[1];

            if (command.equals("Remove")) {
                if (secondCommand.equals("StartsWith")) {
                    String lastCommand = tokens[2];
                    names = names.stream().filter(name -> !name.startsWith(lastCommand)).collect(Collectors.toList());
                } else if (secondCommand.equals("EndsWith")) {
                    String lastCommand = tokens[2];
                    names = names.stream().filter(name -> !name.endsWith(lastCommand)).collect(Collectors.toList());
                } else if (secondCommand.equals("Length")) {
                    int namesLength = Integer.parseInt(tokens[2]);
                    names = names.stream().filter(name -> name.length() != namesLength).collect(Collectors.toList());
                }

            } else if (command.equals("Double")) {
                if (secondCommand.equals("StartsWith")) {
                    String lastCommand = tokens[2];
                    BiPredicate<String, String> doubleStartsWithPredicate = String::startsWith;
                    List<String> current = names.stream().filter(name -> doubleStartsWithPredicate.test(name, lastCommand)).collect(Collectors.toList());
                    for (int i = 0; i < current.size(); i++) {
                        names.add(names.indexOf(current.get(i)),current.get(i));
                    }

                } else if (secondCommand.equals("EndsWith")) {
                    String lastCommand = tokens[2];
                    BiPredicate<String, String> doubleEndsWithPredicate = String::endsWith;
                    List<String> current = names.stream().filter(name -> doubleEndsWithPredicate.test(name, lastCommand)).collect(Collectors.toList());
                    for (int i = 0; i < current.size(); i++) {
                        names.add(names.indexOf(current.get(i)), current.get(i));
                    }
                } else if (secondCommand.equals("Length")) {
                    int namesLength = Integer.parseInt(tokens[2]);
                    BiPredicate<String, Integer> doubleLengthPredicate = (name, length) -> name.length() == length;
                    List<String> current = names.stream().filter(name -> doubleLengthPredicate.test(name, namesLength)).collect(Collectors.toList());
                    for (int i = 0; i < current.size(); i++) {
                        names.add(names.indexOf(current.get(i)), current.get(i));
                    }

                }
            }
        }

        Collections.sort(names);
        if (!names.isEmpty()) {

            System.out.println(String.join(", ", names) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
