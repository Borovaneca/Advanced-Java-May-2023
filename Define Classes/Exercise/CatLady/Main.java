package Advance.DefineClasses.Exercise.CatLady;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        HashMap<String, Cat> catList = new HashMap<>();

        String catInput = scanner.nextLine();

        while (!catInput.equals("End")) {
            String[] catData = catInput.split("\\s+");
            String type = catData[0];
            String name = catData[1];
            double number = Double.parseDouble(catData[2]);

            Cat currentCat = new Cat();

            if (type.equals("Siamese")) {
                currentCat = new Siamese(name, number);
            } else if (type.equals("Cymric")) {
                currentCat = new Cymric(name, number);
            } else if (type.equals("StreetExtraordinaire")) {
                currentCat = new StreetExtraordinaire(name, number);
            }

            catList.put(name, currentCat);


            catInput = scanner.nextLine();
        }

        String nameOfTheCat = scanner.nextLine();

        catList.values().stream()
                .filter(item -> item.getName().equals(nameOfTheCat))
                .forEach(System.out::print);
    }
}
