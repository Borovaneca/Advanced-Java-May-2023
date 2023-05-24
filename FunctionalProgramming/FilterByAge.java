package Advance.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) throws IOException {

        BiPredicate<Integer, Map.Entry<String, Integer>> filterYounger = (age, value) -> {
            return age > value.getValue();
        };

        BiPredicate<Integer, Map.Entry<String, Integer>> filterOlder = (age, value) -> {
            return age <= value.getValue();
        };

        Consumer<Map.Entry<String, Integer>> namePrinter = entry -> {
            System.out.println(entry.getKey());
        };

        Consumer<Map.Entry<String, Integer>> agePrinter = entry -> {
            System.out.println(entry.getValue());
        };

        Consumer<Map.Entry<String, Integer>> entryPrinter = entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        };

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int numberOfPeople = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] line = bufferedReader.readLine().split(", ");
            String name = line[0];
            Integer age = Integer.parseInt(line[1]);

            people.put(name, age);
        }

        String commandType = bufferedReader.readLine();
        int specificAge = Integer.parseInt(bufferedReader.readLine());
        String outputType = bufferedReader.readLine();

        Consumer<Map.Entry<String, Integer>> printer = null;


        if (outputType.equals("age")) {
            printer = agePrinter;
        } else if (outputType.equals("name")) {
            printer = namePrinter;
        } else {
            printer = entryPrinter;
        }

        BiPredicate<Integer, Map.Entry<String, Integer>> filterAge = null;
        if (commandType.equals("younger")) {
            filterAge = filterYounger;
        } else {
            filterAge = filterOlder;
        }

        BiPredicate<Integer, Map.Entry<String, Integer>> finalFilterAge = filterAge;
        people.entrySet().stream().filter(entry -> finalFilterAge.test(specificAge, entry))
                .forEach(printer::accept);

    }
}