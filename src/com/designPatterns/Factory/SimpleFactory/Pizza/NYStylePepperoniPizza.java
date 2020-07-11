package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Collections;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        super(Collections.singletonList("Pepperoni"));
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
