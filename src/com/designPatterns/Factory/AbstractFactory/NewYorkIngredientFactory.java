package com.designPatterns.Factory.AbstractFactory;

import com.designPatterns.Factory.AbstractFactory.Ingredients.*;

public class NewYorkIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Veggies createVeggies() {
        return null;
    }

    @Override
    public Pepperoni createPepperoni() {
        return null;
    }

    @Override
    public Clam createClam() {
        return null;
    }
}
