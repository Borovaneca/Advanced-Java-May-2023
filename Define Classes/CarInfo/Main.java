package Advance.DefineClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Car> carsList = new ArrayList<>();

        int carsAmount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= carsAmount; i++) {
            String[] inputDataCar = scanner.nextLine().split("\\s+");
            Car currentCar = new Car(inputDataCar[0], inputDataCar[1], Integer.parseInt(inputDataCar[2]));
            carsList.add(currentCar);
        }

        carsList.forEach(item -> System.out.printf("The car is: %s %s - %d HP.%n", item.getBrand(), item.getModel(), item.getHorsePower()));


    }
}
