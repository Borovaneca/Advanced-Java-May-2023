package Advance.SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> personsListSet = new TreeSet<>();

        String command = scanner.nextLine();
        boolean partyOn = false;

        while (!command.equals("END")) {

            if (command.equals("PARTY")) {
                command = scanner.nextLine();
                partyOn = true;
                continue;
            } else if (command.length() != 8) {
                command = scanner.nextLine();
                continue;
            }

            if (partyOn) {
                personsListSet.remove(command);
            } else {
                personsListSet.add(command);
            }


            command = scanner.nextLine();
        }

        System.out.println(personsListSet.size());
        for (String item : personsListSet) {
            System.out.println(item);
        }
    }
}
