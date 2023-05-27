package Advance.DefineClasses.Exercise.Google;

public class Car {
   private String model;
   private int carSpeed;


    public Car(String model, int carSpeed) {
        this.model = model;
        this.carSpeed = carSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
}
