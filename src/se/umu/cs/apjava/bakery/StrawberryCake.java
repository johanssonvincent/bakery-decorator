package se.umu.cs.apjava.bakery;

/**
 * StrawberryCake implementation of the Cake interface
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class StrawberryCake implements Cake {

    @Override
    public int getCost() {
        return BASE_COST * 2;
    }

    @Override
    public String getDescription() {
        return "Strawberry cake ";
    }
}
