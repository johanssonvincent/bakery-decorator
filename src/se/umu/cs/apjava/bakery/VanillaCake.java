package se.umu.cs.apjava.bakery;

/**
 * VanillaCake implementation of the Cake interface
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class VanillaCake implements Cake {

    @Override
    public int getCost() {
        return BASE_COST;
    }

    @Override
    public String getDescription() {
        return "Vanilla cake ";
    }
}
