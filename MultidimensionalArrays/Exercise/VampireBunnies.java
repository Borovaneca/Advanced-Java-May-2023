package Advance.Matrices.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VampireBunnies {
    private static String FREE_SPACE_MARK = ".";
    private static String BUNNY_MARK = "B";
    private static String PLAYER_MARK = "P";
    private static int PLAYER_ROW = -1;
    private static int PLAYER_COL = -1;
    private static boolean gameWon;
    private static int PLAYER_WIN_ROW = Integer.MIN_VALUE;
    private static int PLAYER_WIN_COL = Integer.MIN_VALUE;
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        matrix = new String[sizes[0]][sizes[1]];
        fillMatrix(bufferedReader);
        String[] commands = Arrays.stream(bufferedReader.readLine().split("")).filter(w -> !w.equals("")).toArray(String[]::new);


        String message = null;
        for (int i = 0; i < commands.length; i++) {

            boolean playerStepOnBunny = false;
            try {
                playerStepOnBunny = !movePlayer(commands[i]);
            } catch (Exception ex) {
                gameWon = true;
            }

            boolean gameOver = spreadBunnies();

            if (gameWon) {
                message = String.format("won: %s %s", PLAYER_WIN_ROW, PLAYER_WIN_COL);
                break;
            }

            if (gameOver || playerStepOnBunny) {
                message = String.format("dead: %s %s", PLAYER_ROW, PLAYER_COL);
                break;
            }


        }
        printMatrix();
        System.out.println(message);
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean spreadBunnies() {
        String[][] newMatrix = makeCopy(matrix);
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[0].length; col++) {
                if (matrix[row][col].equals(BUNNY_MARK)) {
                    spread(row - 1, col, newMatrix);
                    spread(row + 1, col, newMatrix);
                    spread(row, col - 1, newMatrix);
                    spread(row, col + 1, newMatrix);
                }
            }
        }

        if (!gameWon && newMatrix[PLAYER_ROW][PLAYER_COL].equals(BUNNY_MARK)) {
            matrix = newMatrix;
            return true;
        }
        matrix = newMatrix;
        return false;
    }

    private static void spread(int row, int col, String[][] matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            matrix[row][col] = "B";
        }
    }

    private static String[][] makeCopy(String[][] matrix) {
        String[][] newCopy = new String[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newCopy[i][j] = matrix[i][j];
            }
        }
        return newCopy;
    }


    private static boolean movePlayer(String direction) {
        PLAYER_WIN_ROW = PLAYER_ROW;
        PLAYER_WIN_COL = PLAYER_COL;
        switch (direction) {
            case "U":
                PLAYER_ROW--;
                break;
            case "D":
                PLAYER_ROW++;
                break;
            case "L":
                PLAYER_COL--;
                break;
            case "R":
                PLAYER_COL++;
                break;
            default:
                break;
        }

        matrix[PLAYER_WIN_ROW][PLAYER_WIN_COL] = FREE_SPACE_MARK;


        if (matrix[PLAYER_ROW][PLAYER_COL].equals(BUNNY_MARK)) {
            return false;
        }
        matrix[PLAYER_ROW][PLAYER_COL] = PLAYER_MARK;
        return true;
    }

    private static void fillMatrix(BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            String currentLine = bufferedReader.readLine();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i] = currentLine.split("");
                if (PLAYER_ROW == -1 && PLAYER_COL == -1 && currentLine.contains("P")) {
                    PLAYER_ROW = i;
                    PLAYER_COL = currentLine.indexOf("P");
                }
            }
        }
    }
}
