package com.designPatterns.Decorator;

public class ChocolateDecorator implements CondimentsDecorator {
    Beverage beverage;
    public static final int COST_OF_CHOCOLATE = 1;

    public ChocolateDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with chocolate";
    }

    @Override
    public int getCost() {
        return 1 + this.beverage.getCost();
    }
}
