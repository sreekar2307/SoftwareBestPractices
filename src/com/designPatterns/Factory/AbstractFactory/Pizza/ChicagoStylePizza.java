package com.designPatterns.Factory.AbstractFactory.Pizza;


import com.designPatterns.Factory.AbstractFactory.ChicagoIngredientFactory;
import com.designPatterns.Factory.AbstractFactory.PizzaIngredientFactory;

public class ChicagoStylePizza extends Pizza {


    protected ChicagoStylePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(new ChicagoIngredientFactory());
    }

    @Override
    public void bake() {
        System.out.println("Baking for 20 min on 400F");
    }

    @Override
    public void box() {
        System.out.println("Boxing the pizza in 12 inch nox");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into four slices");
    }
}
