package Advance.Matrices.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class ParkingSystem {
    private static LinkedHashMap<String, Boolean> memo;
    private static String input;
    private static int ROW_LENGTH;
    private static int COL_LENGTH;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] sizes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ROW_LENGTH = sizes[0];
        COL_LENGTH = sizes[1];


        memo = new LinkedHashMap<>();

        input = bufferedReader.readLine();

        while (!input.equals("stop")) {
            int[] intLines = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = intLines[0];
            int destRow = intLines[1];
            int destCol = intLines[2];

            int steps = parkCar(entryRow, destRow, destCol);

            if (steps == -1) {
                System.out.printf("Row %d full%n", destRow);
                input = bufferedReader.readLine();
                continue;
            }
            System.out.println(steps);


            input = bufferedReader.readLine();
        }
    }

    private static int parkCar(int entryRow, int destRow, int destCol) {
        int steps = 1;
        if (entryRow > destRow) {
            steps += entryRow - destRow;

        } else {
            steps += destRow - entryRow;
        }

        int result = findSpot(entryRow, destRow, destCol);

        if (result == -1) {
            return -1;
        }


        return result + steps;
    }

    private static int findSpot(int entryRow, int row, int col) {
        int left = col;
        int right = col;
        String inputKey = String.format("%s %s", row, col);


        if (!memo.containsKey(inputKey)) {
            memo.put(inputKey, true);
            return col;
        }

        while (left >= 1 || right <= COL_LENGTH) {
            inputKey = String.format("%s %s", row, left);

            if (left >= 1 && !memo.containsKey(inputKey)) {
                memo.put(inputKey, true);
                return left;
            }

            inputKey = String.format("%s %s", row, right);
            if (right < COL_LENGTH && !memo.containsKey(inputKey)) {
                memo.put(inputKey, true);
                return right;
            }
            left--;
            right++;
        }
        return -1;
    }
}
