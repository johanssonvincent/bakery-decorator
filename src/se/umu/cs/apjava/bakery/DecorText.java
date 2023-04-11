package se.umu.cs.apjava.bakery;

/**
 * Text decorator extending the CakeDecorator class
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class DecorText extends CakeDecorator {

    private String str;

    /**
     * Initialize a DecorText object
     * @param cake the cake that should have added text
     * @param str the String with the text the user wants on the cake
     */
    public DecorText(Cake cake, String str) {
        super(cake);
        this.str = str;
    }

    @Override
    public int getCost() {
        return decoratedCake.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return decoratedCake.getDescription() + "with text: " + this.str;
    }
}