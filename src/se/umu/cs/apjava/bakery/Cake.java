package se.umu.cs.apjava.bakery;

/**
 * Cake interface
 */
public interface Cake {

    int BASE_COST = 10;

    /**
     * Returns the cakes price
     * @return int the price
     */
    int getCost();

    /**
     * Returns the description of the ordered cake
     * @return String with the description of the cake
     */
    String getDescription();
}
