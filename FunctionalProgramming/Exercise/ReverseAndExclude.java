package Advance.FunctionalProgramming.Exercise;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer divideByNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        numbers.removeIf(num -> num % divideByNumber == 0);
        numbers.forEach(item -> System.out.printf("%d ", item));
    }
}
