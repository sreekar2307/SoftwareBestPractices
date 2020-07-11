package com.designPatterns.Decorator;

public class ChaiTea implements Beverage {
    @Override
    public String getDescription() {
        return "you have ordered a chai-tea";
    }

    @Override
    public int getCost() {
        return 8;
    }
}
