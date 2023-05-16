package Advance.SetsAndMaps.Exercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        HashMap<String, String> phonebookMap = new HashMap<>();
        String inputNamesAndNumber = scanner.nextLine();

        while (!"search".equals(inputNamesAndNumber)) {
            String name = inputNamesAndNumber.split("-")[0];
            String phoneNumber = inputNamesAndNumber.split("-")[1];
            phonebookMap.put(name, phoneNumber);

            inputNamesAndNumber = scanner.nextLine();
        }

        String searchingByName = scanner.nextLine();

        while (!"stop".equals(searchingByName)) {
            if (phonebookMap.containsKey(searchingByName)) {
                System.out.printf("%s -> %s%n", searchingByName, phonebookMap.get(searchingByName));
            } else {
                System.out.println("Contact " + searchingByName + " does not exist.");
            }

            searchingByName = scanner.nextLine();
        }
    }
}
