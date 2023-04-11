package se.umu.cs.apjava.bakery;


public class ExtraLarge extends CakeDecorator {

    public ExtraLarge(Cake cake) {
        super(cake);
    }

    @Override
    public int getCost() {
        return decoratedCake.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + "extra large ";
    }
}
