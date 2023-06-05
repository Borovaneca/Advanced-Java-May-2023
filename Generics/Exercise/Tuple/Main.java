package Advance.Generics.Exercise.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Tuple<String, String>> tupleList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                String[] input = scanner.nextLine().split("\\s+");
                String name = input[0] + " " + input[1];
                String city = input[2];
                tupleList.add(new Tuple<>(name, city));
            } else if (i == 1) {
                String[] input = scanner.nextLine().split("\\s+");
                String name = input[0];
                String liters = input[1];
                tupleList.add(new Tuple<>(name, liters));
            } else {
                String[] input = scanner.nextLine().split("\\s+");
                String integer = input[0];
                String doublee = input[1];
                tupleList.add(new Tuple<>(integer, doublee));
            }
        }

        tupleList.forEach(System.out::println);

    }
}
