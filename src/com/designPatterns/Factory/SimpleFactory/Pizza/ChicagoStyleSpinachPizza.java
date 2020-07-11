package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Arrays;
import java.util.Collections;

public class ChicagoStyleSpinachPizza extends Pizza {
    public ChicagoStyleSpinachPizza() {
        super(Collections.singletonList("Spinach"));
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
