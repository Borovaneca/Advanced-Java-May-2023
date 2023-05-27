package Advance.DefineClasses.Exercise.CatLady;

public class StreetExtraordinaire extends Cat{

    private double meowDecibels;
    private String type = "StreetExtraordinaire";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StreetExtraordinaire(String name, double meowDecibels) {
        super(name);
        this.meowDecibels = meowDecibels;
    }

    public double getMeowDecibels() {
        return meowDecibels;
    }

    public void setMeowDecibels(int meowDecibels) {
        this.meowDecibels = meowDecibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f%n", getName(), getMeowDecibels());
    }
}
