package Advance.Matrices;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix1 = new int[rows][cols];

        String[] index = new String[2];
        int sumIndex = 0;
        for (int i = 0; i < matrix1.length; i++) {
            String[] current = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = Integer.parseInt(current[j]);
            }
        }

        for (int i = 0; i < matrix1.length - 1; i++) {
            for (int j = 0; j < matrix1[i].length - 1; j++) {
                if ((matrix1[i][j] + matrix1[i][j+1]) + (matrix1[i+1][j] + matrix1[i+1][j+1]) > sumIndex) {
                    sumIndex = (matrix1[i][j] + matrix1[i][j+1]) + (matrix1[i+1][j] + matrix1[i+1][j+1]);
                    index[0] = String.valueOf(i);
                    index[1] = String.valueOf(j);
                }
            }
        }

        int startRow = Integer.parseInt(index[0]);
        int endRow = startRow + 1;
        int startIndex = Integer.parseInt(index[1]);
        int endIndex = startIndex + 1;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startIndex; j <= endIndex; j++) {
                System.out.printf("%d ", matrix1[i][j]);
            }
            System.out.println();
        }
        System.out.println(sumIndex);
    }
}
