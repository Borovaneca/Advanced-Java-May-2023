package Advance.Matrices.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputMatrixData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[inputMatrixData[0]][inputMatrixData[1]];
        for (int i = 0; i < matrix.length; i++) {
            int[] current = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = current;
        }

        int row = 0;
        int col = 0;
        int sum = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                if (matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
                    matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +
                    matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2] > sum) {

                    sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
                            matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +
                            matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("Sum = " + sum);
        int endRow = row+2;
        int endCol = col+2;
        for (int i = row; i <= endRow; i++) {
            for (int j = col; j <= endCol; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
