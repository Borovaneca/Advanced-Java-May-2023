package Advance.Matrices.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        char[][] matrix = new char[rowsAndCols[0]][rowsAndCols[1]];

        for (int r = 0; r < rowsAndCols[0]; r++) {
            matrix[r] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char newColor = scanner.nextLine().charAt(0);

        int[] clickedPixels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int clickedRow = clickedPixels[0];
        int clickedCol = clickedPixels[1];

        char oldColor = matrix[clickedRow][clickedCol];
        paint(matrix, newColor, oldColor, clickedRow, clickedCol);

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void paint(char[][] matrix, char newColor, char oldColor, int clickedRow, int clickedCol) {
        if (isOutOfBounce(matrix, clickedRow, clickedCol) || matrix[clickedRow][clickedCol] != oldColor) {
            return;
        }

        matrix[clickedRow][clickedCol] = newColor;

        paint(matrix, newColor, oldColor, clickedRow + 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow - 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol + 1);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol - 1);
    }

    private static boolean isOutOfBounce(char[][] matrix, int clickedRow, int clickedCol) {
        return clickedRow < 0 || clickedRow >= matrix.length || clickedCol < 0 || clickedCol >= matrix[clickedRow].length;
    }
}
