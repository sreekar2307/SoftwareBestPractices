package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Arrays;

import static java.lang.String.format;
import static java.lang.String.join;

public class ChicagoStylePizza extends Pizza {
    public ChicagoStylePizza() {
        super(Arrays.asList("Extra cheese","Thick Crust","Rich Sauce"));
    }

    @Override
    public void prepare() {
        System.out.println(format("Added these toppings %s for Chicago style Pizza", join(",", toppings)));
    }

    @Override
    public void bake() {
        System.out.println("Baking for 20 min on 400F");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into four slices");
    }
}
