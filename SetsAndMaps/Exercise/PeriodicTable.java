package Advance.SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rotation = Integer.parseInt(scanner.nextLine());
        TreeSet<String> periodicTableSet = new TreeSet<>();

        for (int i = 0; i < rotation; i++) {
            String[] currentElement = scanner.nextLine().split("\\s+");
            periodicTableSet.addAll(Arrays.asList(currentElement));
        }

        periodicTableSet.forEach(item -> System.out.print(item + " "));
    }
}
