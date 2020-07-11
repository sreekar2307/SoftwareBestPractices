package com.designPatterns.Factory.SimpleFactory.PizzaStore;

import com.designPatterns.Factory.SimpleFactory.Pizza.*;

public class NewYorkStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "veggie":
                return new NYStyleVeggiePizza();
            case "clam":
                return new NYStyleClamPizza();
            case "pepperoni":
                return new NYStylePepperoniPizza();
            case "cheese":
            default:
                return new NewYorkStylePizza();
        }
    }
}
