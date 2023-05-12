package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbersToElaborate = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbersToAdd = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int amountOfNumbersToAdd = numbersToElaborate[0];
        int amountOfNumbersToRemove = numbersToElaborate[1];
        int numberToCheck = numbersToElaborate[2];

        ArrayDeque<Integer> numberQueue = new ArrayDeque<>();

        for (int i = 0; i < amountOfNumbersToAdd; i++) {
            numberQueue.offer(numbersToAdd[i]);
        }

        for (int i = 0; i < amountOfNumbersToRemove; i++) {
            numberQueue.poll();
        }
        if (numberQueue.isEmpty()) {
            System.out.println(0);
        } else if (numberQueue.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            int minValue = Integer.MAX_VALUE;
            for (Integer integer : numberQueue) {
                if (integer < minValue) {
                    minValue = integer;
                }
            }
            System.out.println(minValue);
        }
    }
}
