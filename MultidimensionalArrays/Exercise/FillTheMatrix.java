package Advance.Matrices.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(",\\s+");
        int number = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[number][number];

        if (type.equals("A")) {
            matrix = typeA(matrix);
        } else {
            matrix = typeB(matrix);
        }

        for (int[] item : matrix) {
            for (int current : item) {
                System.out.printf("%d ", current);
            }
            System.out.println();
        }
    }


    private static int[][] typeA (int[][] matrix) {
        int currentNum = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = currentNum;
                currentNum++;
            }
        }
        return matrix;
    }


    private static int[][] typeB (int[][] matrix) {
        int currentNum = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 != 0) {
                for (int j = matrix.length-1; j >= 0; j--) {
                    matrix[j][i] = currentNum;
                    currentNum++;
                }
            } else {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = currentNum;
                    currentNum++;
                }
            }
        }
        return matrix;
    }
}
