package Advance.Matrices.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] matrixLength = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixLength[0]][matrixLength[1]];
        for (int i = 0; i < matrix.length; i++) {
            String[] current = scanner.nextLine().split(" ");
            matrix[i] = current;
        }

        String command = scanner.nextLine();

        while (!command.contains("END")) {
            String[] commandArr = command.split(" ");
            if (!commandArr[0].equals("swap") || commandArr.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            boolean exception = false;
            for (int i = 1; i < commandArr.length; i++) {
                for (int j = 0; j < commandArr[i].length(); j++) {
                    if (!Character.isDigit(commandArr[i].charAt(j))) {
                        System.out.println("Invalid input!");
                        exception = true;
                        break;
                    }
                }
                if (exception){
                    break;
                }
            }
            if (exception) {
                command = scanner.nextLine();
                continue;
            }
            int oldRow = Integer.parseInt(commandArr[1]);
            int oldCol = Integer.parseInt(commandArr[2]);
            int newRow = Integer.parseInt(commandArr[3]);
            int newCol = Integer.parseInt(commandArr[4]);
            if (oldRow > matrix.length - 1 || oldCol > matrix[0].length - 1 ||
                    newRow > matrix.length - 1 || newCol > matrix[0].length - 1 ||
                    oldRow < 0 || oldCol < 0 || newRow < 0 || newCol < 0) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            String oldValue = matrix[oldRow][oldCol];
            String newValue = matrix[newRow][newCol];
            matrix[oldRow][oldCol] = newValue;
            matrix[newRow][newCol] = oldValue;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.printf("%s ", matrix[i][j]);
                }
                System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
