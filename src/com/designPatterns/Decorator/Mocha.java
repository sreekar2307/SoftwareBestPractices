package com.designPatterns.Decorator;

public class Mocha implements Beverage{
    @Override
    public String getDescription() {
        return "you have ordered a Mocha";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
