package com.designPatterns.Factory.SimpleFactory;

import com.designPatterns.Factory.SimpleFactory.Pizza.Pizza;
import com.designPatterns.Factory.SimpleFactory.PizzaStore.NewYorkStylePizzaStore;
import com.designPatterns.Factory.SimpleFactory.PizzaStore.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NewYorkStylePizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
    }
}
