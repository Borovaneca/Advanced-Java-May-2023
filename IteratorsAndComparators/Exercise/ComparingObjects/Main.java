package Advance.IteratorsAndComparators.Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!"END".equals(input)) {
            String[] inputData = input.split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            String city = inputData[2];
            Person person = new Person(name, age, city);
            people.add(person);

            input = scanner.nextLine();
        }

        int importantPersonIndex = Integer.parseInt(scanner.nextLine());
        int allPeopleCount = people.size();
        int samePeople = 1;
        boolean founded = false;

        Person mainPerson = people.get(importantPersonIndex - 1);

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).compareTo(people.get(importantPersonIndex - 1)) == 0 && i != importantPersonIndex - 1) {
                samePeople++;
                founded = true;
            }
        }

        if (founded) {

            System.out.println(String.join(" ", String.valueOf(samePeople), String.valueOf(people.size() - samePeople), String.valueOf(allPeopleCount)));
        } else {
            System.out.println("No matches");
        }

    }
}
