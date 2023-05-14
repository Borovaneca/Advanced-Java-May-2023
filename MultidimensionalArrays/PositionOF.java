package Advance.Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] numbers = new int[inputData[0]][inputData[1]];
        for (int r = 0; r < numbers.length; r++) {
            int[] currentArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            numbers[r] = currentArr;
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());

        finderOfNum(numbers, numberToFind);

    }

    private static void finderOfNum(int[][] numbers, int numberToFind) {
        boolean finder = false;
        for (int r = 0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[r].length; c++) {
                if (numbers[r][c] == numberToFind) {
                    System.out.printf("%d %d%n", r, c);
                    finder = true;
                }
            }
        }
        if (!finder) {
            System.out.println("not found");
        }
    }
}
