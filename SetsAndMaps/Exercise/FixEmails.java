package Advance.SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emailMap = new LinkedHashMap<>();
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            if (!emailMap.containsKey(name)) {
                emailMap.put(name, "");
            }

            String emailInput = scanner.nextLine().toLowerCase();
            if (emailInput.contains(".us") || emailInput.contains(".uk") || emailInput.contains(".com")) {
                emailMap.remove(name);
            } else {
                emailMap.put(name, emailInput);
            }
//            } else {
//                System.out.printf("%s -> %s%n", name, emailInput);
//            }
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> item : emailMap.entrySet()) {
            System.out.printf("%s -> %s%n", item.getKey(), item.getValue());
        }

    }
}
