package nl.saxion.re.solarsmart;

public class SolarPanel extends Item{

    private double height;
    private double width;
    private double generatedPower;

    public SolarPanel () {

        super("SunBurn Factor 50", 200);
        this.height = 1.754;
        this.width = 1.096;
        this.generatedPower = 405;

    }
    /* overloading https://www.mygreatlearning.com/blog/method-overloading-in-java/#:~:text=Method%20overloading%20in%20java%20is,name%2C%20but%20with%20different%20parameters. */
    public SolarPanel (String name, double price, double height, double width, double generatedPower) {

        super(name, price);
        this.height = height;
        this.width = width;
        this.generatedPower = generatedPower;

    }
    public double getLength() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getGeneratedPower() {
        return generatedPower;
    }
}
