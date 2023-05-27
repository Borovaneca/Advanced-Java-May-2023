package Advance.DefineClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int rotation = Integer.parseInt(scanner.nextLine());

        List<Person> peopleList = new ArrayList<>();

        for (int i = 1; i <= rotation; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            Person person = new Person(name, age);
            peopleList.add(person);
        }
        peopleList.stream()
                .filter(e -> e.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .forEach(item -> System.out.printf("%s - %d%n", item.getName(), item.getAge()));
    }
}
