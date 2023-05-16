package Advance.SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        TreeMap<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (!symbolMap.containsKey(current)) {
                symbolMap.put(current, 1);
            } else {
                symbolMap.put(current, symbolMap.get(current) + 1);
            }
        }

        for (Map.Entry<Character, Integer> item : symbolMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", item.getKey(), item.getValue());
        }

    }
}
