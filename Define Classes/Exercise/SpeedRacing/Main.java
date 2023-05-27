package Advance.DefineClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rotation = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < rotation; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String model = inputData[0];
            double fuel = Double.parseDouble(inputData[1]);
            double fuelCost = Double.parseDouble(inputData[2]);

            if (!carMap.containsKey(model)) {
                Car car = new Car(model, fuel, fuelCost);
                carMap.put(model, car);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandArr = command.split("\\s+");
            String model = commandArr[1];
            int kilometersToDrive = Integer.parseInt(commandArr[2]);

            carMap.get(model).drive(kilometersToDrive);


            command = scanner.nextLine();
        }

        for (Map.Entry<String, Car> car : carMap.entrySet()) {
            System.out.printf("%s %.2f %d%n", car.getValue().getModel(), car.getValue().getFuel(), car.getValue().getDistanceTraveled());
        }

    }
}
