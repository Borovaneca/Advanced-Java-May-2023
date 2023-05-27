package Advance.DefineClasses.Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();
        for (int i = 1; i <= rotation; i++) {
            String[] inputCarData = scanner.nextLine().split("\\s+");
            String model = inputCarData[0];
            int engineSpeed = Integer.parseInt(inputCarData[1]);
            int enginePower = Integer.parseInt(inputCarData[2]);
            int cargoWeight = Integer.parseInt(inputCarData[3]);
            String cargoType = inputCarData[4];
            double tire1Pressure = Double.parseDouble(inputCarData[5]);
            int tire1Age = Integer.parseInt(inputCarData[6]);
            double tire2Pressure = Double.parseDouble(inputCarData[7]);
            int tire2Age = Integer.parseInt(inputCarData[8]);
            double tire3Pressure = Double.parseDouble(inputCarData[9]);
            int tire3Age = Integer.parseInt(inputCarData[10]);
            double tire4Pressure = Double.parseDouble(inputCarData[11]);
            int tire4Age = Integer.parseInt(inputCarData[12]);

            Car current = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1Pressure, tire1Age,
                    tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            carList.add(current);
        }


        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Car car : carList) {
                if (car.getTires().ifTirePressureIsUnder() && car.getCargo().getCargoType().equals("fragile")) {
                    System.out.printf("%s%n", car.getModel());
                }
            }


        } else if (command.equals("flamable")) {
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250) {
                    System.out.printf("%s%n", car.getModel());
                }
            }
        }

    }
}
