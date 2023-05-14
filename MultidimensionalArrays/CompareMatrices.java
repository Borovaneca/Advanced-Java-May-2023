package Advance.Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
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

        String output = (Arrays.deepEquals(firstMatrix, secondMatrix)) ? "equal" : "not equal";
        System.out.println(output);
    }
}
