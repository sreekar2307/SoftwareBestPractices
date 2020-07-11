package com.designPatterns.Decorator;

public class CardamomDecorator implements CondimentsDecorator {
    Beverage beverage;
    public static final int COST_OF_CARDAMOM = 1;

    public CardamomDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with cardamom";
    }

    @Override
    public int getCost() {
        return 2 + this.beverage.getCost();
    }
}
