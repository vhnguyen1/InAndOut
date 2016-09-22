package edu.orangecoastcollege.cs273.vnguyen629.inandout;

/**
 * Calculates the total cost of the customer's order
 * @author Vincent Nguyen
 */

public class Order {
    private int mCheeseburgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;

    private static final double PRICE_CHEESEBURGER = 2.15;
    private static final double PRICE_DOUBLE_DOUBLE = 3.60;
    private static final double PRICE_FRENCH_FRIES = 1.65;
    private static final double PRICE_LARGE_DRINK = 1.75;
    private static final double PRICE_MEDIUM_DRINK = 1.55;
    private static final double PRICE_SMALL_DRINK = 1.45;
    private static final double PRICE_SHAKE_ = 2.20;
    private static final double PRICE_TAX_RATE = 0.08;


    public Order() {
        mCheeseburgers = 0;
        mDoubleDoubles =0;
        mFrenchFries = 0;
        mLargeDrinks = 0;
        mMediumDrinks = 0;
        mShakes = 0;
        mSmallDrinks = 0;
    }

    public Order(int aCheeseburgers, int aDoubleDoubles, int aFrenchFries,
                 int aLargeDrinks, int aMediumDrinks, int aShakes, int aSmallDrinks) {
        mCheeseburgers = aCheeseburgers;
        mDoubleDoubles = aDoubleDoubles;
        mFrenchFries = aFrenchFries;
        mLargeDrinks = aLargeDrinks;
        mMediumDrinks = aMediumDrinks;
        mShakes = aShakes;
        mSmallDrinks = aSmallDrinks;
    }

    public double calculateSubtotal() {
        double total = mCheeseburgers * PRICE_CHEESEBURGER;
        total += mDoubleDoubles * PRICE_DOUBLE_DOUBLE;
        total += mFrenchFries * PRICE_FRENCH_FRIES;
        total += mLargeDrinks * PRICE_LARGE_DRINK;
        total += mMediumDrinks * PRICE_MEDIUM_DRINK;
        total += mShakes * PRICE_SHAKE_;
        return total + (mSmallDrinks * PRICE_SMALL_DRINK);
    }

    public double calculateTax() {
        return calculateSubtotal() * PRICE_TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public double getCheeseburgers() {
        return mCheeseburgers;
    }

    public double getDoubleDoubles() {
        return mDoubleDoubles;
    }

    public double getFrenchFries() {
        return mFrenchFries;
    }

    public double getLargeDrinks() {
        return mLargeDrinks;
    }

    public double getMediumDrinks() {
        return mMediumDrinks;
    }

    public int getNumberItemsOrdered() {
        return mCheeseburgers + mDoubleDoubles + mFrenchFries + mLargeDrinks
                + mMediumDrinks + mShakes + mSmallDrinks;
    }

    public double getShakes() {
        return mShakes;
    }

    public double getSmallDrinks() {
        return mSmallDrinks;
    }

    public void setCheeseburgers(int aCheeseburgers) {
        mCheeseburgers = aCheeseburgers;
    }

    public void setDoubleDoubles(int aDoubleDoubles) {
        mDoubleDoubles = aDoubleDoubles;
    }

    public void setFrenchFries(int aFrenchFries) {
        mFrenchFries = aFrenchFries;
    }

    public void setLargeDrinks(int aLargeDrinks) {
        mLargeDrinks = aLargeDrinks;
    }

    public void setMediumDrinks(int aMediumDrinks) {
        mMediumDrinks = aMediumDrinks;
    }

    public void setShakes(int aShakes) {
        mShakes = aShakes;
    }

    public void setSmallDrinks(int aSmallDrinks) {
        mSmallDrinks = aSmallDrinks;
    }
}
