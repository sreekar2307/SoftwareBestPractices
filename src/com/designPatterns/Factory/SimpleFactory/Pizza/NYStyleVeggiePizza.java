package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Arrays;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        super(Arrays.asList("Capsicum", "Peppers"));
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }
}
