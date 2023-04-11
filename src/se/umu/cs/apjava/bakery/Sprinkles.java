package se.umu.cs.apjava.bakery;


public class Sprinkles extends CakeDecorator {

    public Sprinkles(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return decoratedCake.getCost() + 2;
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + "with sprinkles ";
    }
}
