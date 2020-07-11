package com.designPatterns.Decorator;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/***
 * What decorator pattern does is adds extra behaviour on top of the existing in a nice way
 * Example in JAVA Api is BufferedReader
 */
public class Main {
    public static void main(String[] args) {
        Beverage beverage = new ChocolateDecorator(new CaramelDecorator(new Mocha())); // by this kind of chaining I can add as many
                                                                                       // condiments as I like
        System.out.println(beverage.getCost());
        System.out.println(beverage.getDescription());

        Beverage beverage1 = new CardamomDecorator(new ChaiTea());

        System.out.println(beverage1.getCost());
        System.out.println(beverage1.getDescription());
    }
}
