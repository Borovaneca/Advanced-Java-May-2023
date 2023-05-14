package Advance.Matrices.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int matrixLength = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixLength][matrixLength];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = currentArr;
        }

        int sumFirst = 0;
        int sumSecond = 0;
        int indexSecond = matrix.length - 1;
        int indexFirst = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (indexFirst == j) {
                    sumFirst += matrix[i][j];
                }
                if (indexSecond == j) {
                    sumSecond += matrix[i][j];
                }
            }
            indexFirst++;
            indexSecond--;
        }
        int totalSum = Math.abs(sumFirst - sumSecond);
        System.out.println(totalSum);

    }
}
