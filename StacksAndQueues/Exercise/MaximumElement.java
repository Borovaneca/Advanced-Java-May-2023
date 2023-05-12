package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int commandsAmount= Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 1; i <= commandsAmount; i++) {
            String command = scanner.nextLine();

            if (command.charAt(0) == '1') {
                int[] currentNumbers = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                numbersStack.push(currentNumbers[1]);
            } else if (command.charAt(0) == '2') {
                numbersStack.pop();
            } else if (command.charAt(0) == '3') {
                if (numbersStack.isEmpty()) {
                    continue;
                }
                int maxNum = Integer.MIN_VALUE;
                for (Integer integer : numbersStack) {
                    maxNum = (integer > maxNum) ? integer : maxNum;
                }
                System.out.println(maxNum);
            }
        }
    }
}
