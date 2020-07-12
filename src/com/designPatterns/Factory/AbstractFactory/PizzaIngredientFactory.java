package com.designPatterns.Factory.AbstractFactory;

import com.designPatterns.Factory.AbstractFactory.Ingredients.*;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies createVeggies();

    Pepperoni createPepperoni();

    Clam createClam();
}
