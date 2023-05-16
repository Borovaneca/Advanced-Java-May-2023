package Advance.SetsAndMaps;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carSet = new LinkedHashSet<>();
        String carsInput = scanner.nextLine();
        while (!carsInput.equals("END")) {
            String[] inputArr = carsInput.split(",\\s+");
            String currentCommand = inputArr[0];
            String currentCarNumber = inputArr[1];
            if (currentCommand.equals("IN")) {
                carSet.add(currentCarNumber);
            } else if (currentCommand.equals("OUT")) {
                carSet.remove(currentCarNumber);
            }


            carsInput = scanner.nextLine();
        }

        if (carSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String item : carSet) {
                System.out.println(item);
            }
        }
    }
}
