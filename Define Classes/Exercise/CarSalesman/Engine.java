package Advance.DefineClasses.Exercise.CarSalesman;

public class Engine {

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String engineModel, int power) {
        this.model = engineModel;
        this.power = power;
        this.displacement = -1; // invalid value
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int power, int displacement) {
        this(engineModel, power);
        this.displacement = displacement;
    }

    public Engine(String engineModel, int power, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, int power, int displacement, String efficiency) {
        this(engineModel, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(this.power).append(System.lineSeparator());
        sb.append("Displacement: ").append((this.displacement == -1) ? "n/a" : this.displacement).append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.efficiency).append(System.lineSeparator());
        return sb.toString();
    }
}
