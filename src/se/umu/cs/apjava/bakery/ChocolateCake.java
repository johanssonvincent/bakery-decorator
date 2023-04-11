package se.umu.cs.apjava.bakery;

/**
 * ChocolateCake implementation of the Cake interface
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class ChocolateCake implements Cake{

    @Override
    public int getCost() {
        return BASE_COST;
    }

    @Override
    public String getDescription() {
        return "Chocolate cake ";
    }
}
