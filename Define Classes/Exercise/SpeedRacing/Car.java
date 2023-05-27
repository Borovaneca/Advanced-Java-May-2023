package Advance.DefineClasses.Exercise.SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double fuelCostPerKilometer;

    private int distanceTraveled;




    public Car(String model, double fuel, double fuelCostPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.distanceTraveled = 0;
    }

    public void drive(int kilometers) {
        if (this.fuelCostPerKilometer * kilometers > this.fuel) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }

        double calculation = kilometers * this.fuelCostPerKilometer;
        calcFuel(calculation);
        addKilometers(kilometers);
    }

    public void calcFuel(double calculation) {
        this.fuel -= calculation;
    }
    public void addKilometers(int kilometers) {
        this.distanceTraveled += kilometers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public void setFuelCostPerKilometer(double fuelCostPerKilometer) {
        this.fuelCostPerKilometer = fuelCostPerKilometer;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
