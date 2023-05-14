package Advance.Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int matrixLength = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixLength][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        int newValue = 0;
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();
        int item = matrix[row1][col1];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNum = matrix[row][col];
                if (currentNum == item) {

                    if (!(row - 1 < 0) && matrix[row - 1][col] != item) {
                        newValue += matrix[row - 1][col];

                    }
                    if (!(col + 1 > matrix[row].length - 1) && matrix[row][col + 1] != item) {
                        newValue += matrix[row][col + 1];

                    }
                    if (!(col - 1 < 0) && matrix[row][col - 1] != item) {
                        newValue += matrix[row][col - 1];

                    }
                    if (!(row + 1 > matrix.length - 1) && matrix[row + 1][col] != item) {
                        newValue += matrix[row + 1][col];

                    }
                    System.out.printf("%d ", newValue);
                } else {
                    System.out.printf("%d ", matrix[row][col]);
                }
                newValue = 0;
            }
            System.out.println();
        }
    }
}
