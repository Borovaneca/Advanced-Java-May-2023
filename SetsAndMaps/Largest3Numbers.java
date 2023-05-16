package Advance.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (numbersList.size() <= 3) {
            numbersList.forEach(item -> System.out.printf("%d ", item));
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%d ", numbersList.get(i));
            }
        }
    }
}
