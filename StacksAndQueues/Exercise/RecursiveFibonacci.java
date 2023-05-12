package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0l);
        stack.push(1l);

        for (int i = 1; i <= n; i++) {
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            long sum = first + second;
            stack.push(sum);
        }
        System.out.println(stack.peek());

    }
}
