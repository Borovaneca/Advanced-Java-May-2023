package Advance.DefineClasses.Lab.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Car> carsList = new ArrayList<>();


        int rotation = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rotation; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            Car currentCar;
            if (inputData.length > 1) {
                currentCar = new Car(inputData[0], inputData[1], Integer.parseInt(inputData[2]));
            } else {
                currentCar = new Car(inputData[0]);
            }
            carsList.add(currentCar);
        }

        carsList.forEach(item -> System.out.printf("The car is: %s %s - %d HP.%n", item.getBrand(), item.getModel(), item.getHorsePower()));
    }
}
