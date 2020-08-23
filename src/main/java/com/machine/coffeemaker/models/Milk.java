package com.machine.coffeemaker.models;


public class Milk extends Ingredient {

    public Milk(double quantity) {
        super(Ingredient.IngredientEnum.MILK, quantity);
    }
}
