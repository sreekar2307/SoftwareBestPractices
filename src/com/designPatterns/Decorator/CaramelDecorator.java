package com.designPatterns.Decorator;

public class CaramelDecorator implements CondimentsDecorator {
    Beverage beverage;
    public static final int COST_OF_CARAMEL = 2;

    public CaramelDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with caramel";
    }

    @Override
    public int getCost() {
        return COST_OF_CARAMEL + this.beverage.getCost();
    }
}
