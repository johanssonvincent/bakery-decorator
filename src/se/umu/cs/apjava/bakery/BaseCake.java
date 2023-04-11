package se.umu.cs.apjava.bakery;

public class BaseCake implements Cake {

    String cake_type = "";

    // getCost method
    @Override
    public int getCost() {
        return BASE_COST;
    }

    // getDescription method
    @Override
    public String getDescription() {
        return cake_type;
    }
}

