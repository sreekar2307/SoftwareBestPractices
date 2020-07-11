package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.Arrays;

import static java.lang.String.format;
import static java.lang.String.join;

public class NewYorkStylePizza extends Pizza {
    public NewYorkStylePizza() {
        super(Arrays.asList("Cheese","tomato sauce"));
    }

    @Override
    public void prepare() {
        System.out.println(format("Added these toppings %s for New York style Pizza", join(",", toppings)));
    }

    @Override
    public void bake() {
        System.out.println("Baking for 15 min on 300F");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into Six slices");
    }

}
