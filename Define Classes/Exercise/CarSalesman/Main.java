package Advance.DefineClasses.Exercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] engineTokens = scanner.nextLine().split("\\s+");
            String engineModel = engineTokens[0];
            int power = Integer.parseInt(engineTokens[1]);
            Engine engine = createEngine(engineTokens, engineModel, power);
            engines.put(engineModel, engine);
        }
        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            String carModel = carTokens[0];
            String engineModel = carTokens[1];
            Engine engine = engines.get(engineModel);
            Car car = createCar(carTokens, carModel, engine);
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }

    private static Car createCar(String[] carTokens, String carModel, Engine engine) {
        Car car;

        if (carTokens.length == 4) {
            int weight = Integer.parseInt(carTokens[2]);
            String color = carTokens[3];
            car = new Car(carModel, engine, weight, color);
        } else if (carTokens.length == 2) {
            car = new Car(carModel, engine);
        } else {
            try {
                int weight = Integer.parseInt(carTokens[2]);
                car = new Car(carModel, engine, weight);
            } catch (NumberFormatException e) {
                String color = carTokens[2];
                car = new Car(carModel, engine, color);
            }
        }
        return car;
    }

    private static Engine createEngine(String[] engineTokens, String engineModel, int power) {
        Engine engine;

        if (engineTokens.length == 4) {
            int displacement = Integer.parseInt(engineTokens[2]);
            String efficiency = engineTokens[3];
            engine = new Engine(engineModel, power, displacement, efficiency);
        } else if (engineTokens.length == 2) {
            engine = new Engine(engineModel, power);
        } else {
            try {
                int displacement = Integer.parseInt(engineTokens[2]);
                engine = new Engine(engineModel, power, displacement);
            } catch (NumberFormatException e) {
                String efficiency = engineTokens[2];
                engine = new Engine(engineModel, power, efficiency);
            }
        }
        return engine;
    }
}