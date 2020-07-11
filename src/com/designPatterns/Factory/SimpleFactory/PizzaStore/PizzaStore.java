package com.designPatterns.Factory.SimpleFactory.PizzaStore;

import com.designPatterns.Factory.SimpleFactory.Pizza.Pizza;

/**
 * Here we are also doing dependency inversion principle instead PIzzaStore
 * Depending on low level components Concrete Pizza's instead we used factory pattern
 * to depend
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.box();
        pizza.cut();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
