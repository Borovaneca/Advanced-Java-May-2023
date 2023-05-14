package Advance.Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrixWithMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = new int[inputArr[0]][inputArr[1]];

        for (int i = 0; i < inputArr[0]; i++) {
            int[] numbersToInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = numbersToInput;
        }


        int[] secondInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] secondMatrix = new int[secondInput[0]][secondInput[1]];
        for (int i = 0; i < secondInput[0]; i++) {
            int[] numbersToInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = numbersToInput;
        }

        if (equalLength(firstMatrix, secondMatrix)) {
            System.out.println(isEqual(firstMatrix, secondMatrix) ? "equal" : "not equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] first, int[][] second) {
        for (int r = 0; r < first.length; r++) {
            for (int c = 0; c < first[r].length; c++) {
                if (first[r][c] != second[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean equalLength(int[][] first, int[][] second) {
        if (first.length == second.length) {

            for (int r = 0; r < first.length; r++) {
                if (first[r].length != second[r].length) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
