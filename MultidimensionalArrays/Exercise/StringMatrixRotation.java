package Advance.Matrices.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine().split("[()]")[1];

        int degrees = Integer.parseInt(input);


        int rotation = degrees % 360;

        String command = scanner.nextLine();

        int longest = 0;
        List<String> inputList = new ArrayList<>();
        while (!command.equals("END")) {
            inputList.add(command);
            if (command.length() > longest) {
                longest = command.length();
            }
            command = scanner.nextLine();
        }

        char[][] matrix = new char[inputList.size()][longest];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j > inputList.get(i).length() - 1) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = inputList.get(i).charAt(j);
                }
            }
        }

        // ----------------------rotation-------------

        switch (rotation) {
            case 0:
                for (int row = 0; row < matrix.length; row++) {
                    for (int cols = 0; cols < matrix[row].length; cols++) {
                        System.out.printf("%c", matrix[row][cols]);
                    }
                    System.out.println();
                }
                break;
            case 90: {
                char[][] newMatrix = new char[longest][matrix.length];
                int oldRow = matrix.length - 1;
                int oldIndex = 0;
                for (int row = 0; row < newMatrix.length; row++) {
                    for (int cols = 0; cols < newMatrix[row].length; cols++) {
                        newMatrix[row][cols] = matrix[oldRow][oldIndex];
                        oldRow--;
                    }
                    oldRow = matrix.length - 1;
                    oldIndex++;
                }
                printMatrix(newMatrix);
            }
                break;

            case 180: {
                char[][] newMatrix = new char[matrix.length][longest];
                int oldRow = matrix.length - 1;
                int oldIndex = 0;
                for (int row = 0; row < newMatrix.length; row++) {
                    for (int cols = matrix[row].length - 1; cols >= 0; cols--) {
                        newMatrix[row][cols] = matrix[oldRow][oldIndex];
                        oldIndex++;
                    }
                    oldRow--;
                    oldIndex = 0;
                }
                printMatrix(newMatrix); }
                break;

            case 270: {
                char[][] newMatrix = new char[longest][matrix.length];
                int oldRow = 0;
                int oldIndex = longest - 1;
                for (int row = 0; row < newMatrix.length; row++) {
                    for (int cols = 0; cols < newMatrix[row].length; cols++) {
                        newMatrix[row][cols] = matrix[oldRow][oldIndex];
                        oldRow++;
                    }
                    oldRow = 0;
                    oldIndex--;
                }
                printMatrix(newMatrix);
            }
                break;
        }
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix[row].length; cols++) {
                System.out.printf("%c", matrix[row][cols]);
            }
            System.out.println();
        }
    }
}
