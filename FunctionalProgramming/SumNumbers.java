package Advance.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], String> count = element -> "Count = " + Arrays.stream(element).count();
        Function<int[], String> sums = el -> "Sum = " + Arrays.stream(el).sum();

        int[] number = Arrays.stream(bf.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        System.out.println(count.apply(number));
        System.out.println(sums.apply(number));

    }
}
