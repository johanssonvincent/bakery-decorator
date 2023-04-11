package se.umu.cs.apjava.bakery;

/**
 * Decorator implementation of the Cake interface
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public abstract class CakeDecorator implements Cake {

    protected Cake decoratedCake;

    /**
     * Initialize a new se.umu.cs.apjava.bakery.CakeDecorator
     * @param cake Cake interface object
     */
    public CakeDecorator(Cake cake) {
        this.decoratedCake = cake;
    }

    @Override
    public int getCost() {
        return decoratedCake.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription();
    }
}
