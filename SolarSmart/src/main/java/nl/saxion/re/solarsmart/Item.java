package nl.saxion.re.solarsmart;

public class Item {

    protected String name;
    protected double price;

    public Item (String name, double price) {

        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "              price: " + price + " €";
    }
}
