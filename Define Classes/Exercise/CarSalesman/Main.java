package Advance.DefineClasses.Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int engineAmounts = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Engine> engineList = new LinkedHashMap<>();
        LinkedHashMap<String, Car> carList = new LinkedHashMap<>();


        for (int i = 0; i < engineAmounts; i++) {
            String[] inputEngineData = scanner.nextLine().split("\\s+");
            String model = inputEngineData[0];
            int power = Integer.parseInt(inputEngineData[1]);
            Engine engine;
            if (inputEngineData.length == 4) {
                int displacement = Integer.parseInt(inputEngineData[2]);
                String efficiency = inputEngineData[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (inputEngineData.length == 3) {
                if (Character.isDigit(inputEngineData[2].charAt(0))) {
                    int displacement = Integer.parseInt(inputEngineData[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = inputEngineData[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                engine = new Engine(model, power);
            }

            engineList.put(model, engine);

        }

        int carAmounts = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carAmounts; i++) {
            String[] inputCarData = scanner.nextLine().split("\\s+");
            String model = inputCarData[0];
            String engine = inputCarData[1];
            Engine current = engineList.get(engine);
            Car car;
            if (inputCarData.length == 4) {
                int weight = Integer.parseInt(inputCarData[2]);
                String color = inputCarData[3];
                car = new Car(model, current, weight, color);
            } else if (inputCarData.length == 3) {
                if (Character.isDigit(inputCarData[2].charAt(0))) {
                    int weight = Integer.parseInt(inputCarData[2]);
                    car = new Car(model, current, weight);
                } else {
                    String color = inputCarData[2];
                    car = new Car(model, current, color);
                }
            } else {
                car = new Car(model, current);
            }

            carList.put(model, car);
        }


        for (Map.Entry<String, Car> car : carList.entrySet()) {
            System.out.printf("%s:%n" +
                            "%s:%n" +
                            "Power: %d%n" +
                            "Displacement: %s%n" +
                            "Efficiency: %s%n" +
                            "Weight: %s%n" +
                            "Color: %s%n", car.getValue().getModel(), car.getValue().getEngine().getModel(), car.getValue().getEngine().getPower(),(car.getValue().getEngine().getDisplacement() == -1) ? "n/a" : String.valueOf(car.getValue().getEngine().getDisplacement()),
                    car.getValue().getEngine().getEfficiency(), (car.getValue().getWeight() == -1) ? "n/a" : String.valueOf(car.getValue().getWeight()), car.getValue().getColor());
        }

    }
}
