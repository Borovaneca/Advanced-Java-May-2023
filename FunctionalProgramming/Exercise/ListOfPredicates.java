package Advance.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int maxNumber = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToCompare = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> predicate = number -> {
            for (Integer item : numbersToCompare) {
                if (number % item != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= maxNumber; number++) {
            if (predicate.test(number)) {
                System.out.printf("%d ", number);
            }
        }
    }
}
