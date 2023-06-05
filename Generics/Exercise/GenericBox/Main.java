package Advance.Generics.Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Box<Double> boxes = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            boxes.add(Double.parseDouble(element));
        }

        String elementToCompare = scanner.nextLine();

        System.out.println(boxes.countOfGreaterItems(Double.parseDouble(elementToCompare)));
    }
}
