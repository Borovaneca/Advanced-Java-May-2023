package Advance.DefineClasses.Exercise.CatLady;

public class Siamese extends Cat{

    private double earSize;
    private String type = "Siamese";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(int earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f%n", getName(), getEarSize());
    }
}
