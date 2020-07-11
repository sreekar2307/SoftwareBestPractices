package com.designPatterns.Factory.SimpleFactory.PizzaStore;

import com.designPatterns.Factory.SimpleFactory.Pizza.ChicagoStyleSpinachPizza;
import com.designPatterns.Factory.SimpleFactory.Pizza.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        return new ChicagoStyleSpinachPizza();
    }
}
