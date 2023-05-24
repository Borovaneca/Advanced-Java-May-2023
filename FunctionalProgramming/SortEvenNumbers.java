package Advance.FunctionalProgramming;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        getPrintList(numbers);

        Collections.sort(numbers);

        getPrintList(numbers);
    }

    private static void getPrintList(List<Integer> list) {
        System.out.println(list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
