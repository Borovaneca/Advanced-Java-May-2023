package Advance.SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<Double, Integer> numberMap = new LinkedHashMap<>();
        double[] inputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < inputData.length; i++) {
            double currentDouble = inputData[i];
            if (!numberMap.containsKey(currentDouble)) {
                numberMap.put(currentDouble, 1);
            } else {
                numberMap.put(currentDouble, numberMap.get(currentDouble) + 1);
            }
        }
        for (Map.Entry<Double, Integer> item : numberMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", item.getKey(), item.getValue());
        }

    }
}
