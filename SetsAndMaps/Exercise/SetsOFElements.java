package Advance.SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOFElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numberInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetLength = numberInput[0];
        int secondSetLength = numberInput[1];
        LinkedHashSet<Integer> numberSet1 = new LinkedHashSet<>(firstSetLength);
        LinkedHashSet<Integer> numberSet2 = new LinkedHashSet<>(secondSetLength);

        for (int i = 0; i < firstSetLength; i++) {
            int current = Integer.parseInt(scanner.nextLine());
            numberSet1.add(current);
        }

        for (int i = 0; i < secondSetLength; i++) {
            int current = Integer.parseInt(scanner.nextLine());
            numberSet2.add(current);
        }

        for (Integer first : numberSet1) {
            for (Integer second : numberSet2) {
                if (second.equals(first)) {
                    System.out.print(second + " ");
                }
            }
        }
    }
}
