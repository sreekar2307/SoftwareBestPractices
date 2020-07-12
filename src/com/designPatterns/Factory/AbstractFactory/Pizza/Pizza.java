package com.designPatterns.Factory.AbstractFactory.Pizza;

import com.designPatterns.Factory.AbstractFactory.Ingredients.*;
import com.designPatterns.Factory.AbstractFactory.PizzaIngredientFactory;

public abstract class Pizza {
    private Dough dough;
    private Cheese cheese;
    private Veggies veggies;
    private Pepperoni pepperoni;
    private Clam clam;

    private PizzaIngredientFactory pizzaIngredientFactory;

    protected Pizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    public void prepare(){
        cheese = pizzaIngredientFactory.createCheese();
        dough = pizzaIngredientFactory.createDough();
        veggies = pizzaIngredientFactory.createVeggies();
        pepperoni = pizzaIngredientFactory.createPepperoni();
        clam = pizzaIngredientFactory.createClam();
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Veggies getVeggies() {
        return veggies;
    }

    public void setVeggies(Veggies veggies) {
        this.veggies = veggies;
    }

    public Pepperoni getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(Pepperoni pepperoni) {
        this.pepperoni = pepperoni;
    }

    public Clam getClam() {
        return clam;
    }

    public void setClam(Clam clam) {
        this.clam = clam;
    }

    public abstract void bake();

    public abstract void box();

    public abstract void cut();
}
