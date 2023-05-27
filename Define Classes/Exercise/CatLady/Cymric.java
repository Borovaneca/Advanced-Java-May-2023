package Advance.DefineClasses.Exercise.CatLady;

public class Cymric extends Cat{

    private double furLength;
    private String type = "Cymric";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(int furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f%n", getName(), getFurLength());
    }
}
