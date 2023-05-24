package Advance.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int minNumber = numbers.stream().mapToInt(e -> e).min().getAsInt();
        Function<List<Integer>, Integer> findIndex = item -> {
            return item.lastIndexOf(minNumber);
        };
        System.out.println(findIndex.apply(numbers));
    }
}
