package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Arrays;
import java.util.Collections;

public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        super(Collections.singletonList("clams"));
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
