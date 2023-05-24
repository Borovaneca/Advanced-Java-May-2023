package Advance.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindEvenOrOdds {
    public static void main(String[] args) throws IOException {

        Predicate<Integer> even = e -> e % 2 != 0;
        Predicate<Integer> odd = e -> e % 2 == 0;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int[] range = Arrays.stream(buffer.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> input = new ArrayList<>();
        for (int i = range[0]; i <= range[1]; i++) {
            input.add(i);
        }
        String numbersToPrint = buffer.readLine();
        if ("even".equals(numbersToPrint)) {
            System.out.println(String.join(" ", input.stream().filter(odd).map(String::valueOf).collect(Collectors.toList())));
        } else {
            System.out.println(String.join(" ", input.stream().filter(even).map(String::valueOf).collect(Collectors.toList())));
        }

    }
}
