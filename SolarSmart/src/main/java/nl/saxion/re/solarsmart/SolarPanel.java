package nl.saxion.re.solarsmart;

public class SolarPanel extends Item{

    private double length;
    private double width;
    private double generatedPower;

    public SolarPanel (String name, double price, double length, double width, double generatedPower) {

        super(name, price);
        this.length = length;
        this.width = width;
        this.generatedPower = generatedPower;

    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getGeneratedPower() {
        return generatedPower;
    }
}
