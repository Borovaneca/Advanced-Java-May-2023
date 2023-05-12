package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] digitsToInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbersStack.push(digitsToInput[i]);
        }
        for (int i = 1; i <= s; i++) {
            if (!numbersStack.isEmpty()) {
                numbersStack.pop();
            }
        }

        if (numbersStack.contains(x)) {
            System.out.println("true");
        }  else if (numbersStack.isEmpty()){
            System.out.println("0");
        } else {
            System.out.println(numbersStack.peek());
        }

    }
}
