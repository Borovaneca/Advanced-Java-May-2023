package Advance.Matrices;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] chess = new char[8][8];
        for (int i = 0; i < chess.length; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            chess[i] = input.toCharArray();
        }

        int[] queenIndex = new int[2];
        boolean found = false;

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                char currentChar = chess[i][j];
                if (currentChar == 'q') {
                    boolean colon = false;
                    boolean rows = false;
                    for (int k = i; k <= i; k++) {
                        for (int l = j + 1; l < chess[i].length; l++) {
                            char checkingChar = chess[i][l];
                            if (checkingChar == 'q') {
                                colon = true;
                                break;
                            }
                        }
                    }

                    for (int k = i + 1; k < chess.length; k++) {
                        if (chess[k][j] == 'q') {
                            rows = true;
                            break;
                        }
                    }

                    if (!colon && !rows && !diagonally(chess, i, j)) {
                        queenIndex[0] = i;
                        queenIndex[1] = j;
                        found = true;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        for (int i = 0; i < queenIndex.length; i++) {
            System.out.printf("%d ", queenIndex[i]);
        }
    }

    private static boolean diagonally(char[][] matrix, int row, int cols) {
        int index = cols;
        if (row == 0) {
            for (int i = 1; i < matrix.length; i++) {
                cols++;
                if (cols > matrix.length - 1) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
            cols = index;
            for (int i = 1; i < matrix.length; i++) {
                cols--;
                if (cols < 0) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
        } else if (row == matrix.length - 1) {
            for (int i = row - 1; i >= 0; i--) {
                cols--;
                if (cols < 0) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }

            cols = index;
            for (int i = row - 1; i >= 0; i--) {
                cols++;
                if (cols > matrix.length - 1) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
        } else {
            for (int i = row + 1; i < matrix.length; i++) {
                cols++;
                if (cols > matrix.length - 1) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
            cols = index;
            for (int i = row + 1; i < matrix.length; i++) {
                cols--;
                if (cols < 0) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }

            cols = index;
            for (int i = row - 1; i > +0; i--) {
                cols--;
                if (cols < 0) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
            cols = index;
            for (int i = row - 1; i >= 0; i--) {
                cols++;
                if (cols > matrix.length - 1) {
                    break;
                }
                if (matrix[i][cols] == 'q') {
                    return true;
                }
            }
        }
        return false;
    }
}
