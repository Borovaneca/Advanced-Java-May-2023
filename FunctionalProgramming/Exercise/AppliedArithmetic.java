package Advance.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = nums -> nums.stream().map(number -> number + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = nums -> nums.stream().map(number -> number - 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = nums -> nums.stream().map(number -> number * 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = e -> e.forEach(item -> System.out.printf("%d ", item));

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            if (command.equals("add")) {
                numbers = add.apply(numbers);
            } else if (command.equals("subtract")) {
                numbers = subtract.apply(numbers);
            } else if (command.equals("multiply")) {
                numbers = multiply.apply(numbers);
            } else if (command.equals("print")) {
                print.accept(numbers);
                System.out.println();
            }
            command = scanner.nextLine();
        }
    }
}
