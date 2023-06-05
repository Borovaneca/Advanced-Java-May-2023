package Advance.Generics.Exercise.CustomList2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customLists = new CustomList<>();


        while (!input.equals("END")) {
            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];
            if (command.equals("Add")) {
                customLists.add(inputArr[1]);
            } else if (command.equals("Remove")) {
                customLists.remove(Integer.parseInt(inputArr[1]));
            } else if (command.equals("Contains")) {
                System.out.println(customLists.contains(inputArr[1]));
            } else if (command.equals("Swap")) {
                customLists.swap(Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
            } else if (command.equals("Greater")) {
                System.out.println(customLists.greaterThan(inputArr[1]));
            } else if (command.equals("Max")) {
                System.out.println(customLists.getMax());
            } else if (command.equals("Min")) {
                System.out.println(customLists.getMin());
            } else if (command.equals("Sort")) {
                Sorter.sort(customLists);
            } else if (command.equals("Print")) {
                System.out.print(customLists);
            }


            input = scanner.nextLine();
        }
    }
}
