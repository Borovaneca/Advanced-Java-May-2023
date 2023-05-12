package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        for (Integer integer : stack) {
            System.out.print(stack.poll() + " ");
        }
    }
}
