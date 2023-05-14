package Advance.Matrices;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] current = scanner.nextLine().split("\\,*\\s+");
            for (int j = 0; j < current.length; j++) {
                matrix[i][j] = Integer.parseInt(current[j]);
                sum += Integer.parseInt(current[j]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
