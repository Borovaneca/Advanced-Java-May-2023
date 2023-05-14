package Advance.Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int inputData = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[inputData][inputData];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int firstIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (firstIndex == j) {
                    System.out.printf("%d ", matrix[i][j]);
                }
            }
            firstIndex++;
        }
        System.out.println();

        int lastIndex = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == lastIndex) {
                    System.out.printf("%d ", matrix[i][j]);
                }
            }
            lastIndex++;
        }
    }
}
