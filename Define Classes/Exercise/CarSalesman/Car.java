package Advance.DefineClasses.Exercise.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String carModel, Engine engine) {
        this.model = carModel;
        this.engine = engine;
        this.weight = -1; // invalid value
        this.color = "n/a";
    }

    public Car(String carModel, Engine engine, int weight) {
        this(carModel, engine);
        this.weight = weight;
    }

    public Car(String carModel, Engine engine, String color) {
        this(carModel, engine);
        this.color = color;
    }

    public Car(String carModel, Engine engine, int weight, String color) {
        this(carModel, engine, weight);
        this.color = color;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine);
        sb.append("Weight: ").append((this.weight == -1) ? "n/a" : this.weight).append(System.lineSeparator());
        sb.append("Color: ").append(this.color).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
