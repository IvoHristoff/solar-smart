package nl.saxion.re.solarsmart;

public class Inverter extends Item{

    private int powerRating;

    public Inverter (String name, double price, int powerRating){

        super(name, price);
        this.powerRating = powerRating;

    }

    public int getPowerRating() {
        return powerRating;
    }

    @Override
    public String toString() {
        return "Inverter " + super.toString();
    }
}
