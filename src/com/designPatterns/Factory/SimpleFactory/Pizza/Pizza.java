package com.designPatterns.Factory.SimpleFactory.Pizza;

import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings;

    public Pizza(List<String> toppings) {
        this.toppings = toppings;
    }

    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public void box() {
        System.out.println("Boxing the Pizza");
    }

}
