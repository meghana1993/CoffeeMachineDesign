package com.machine.coffeemaker.models;

public class CoffeePowder extends Ingredient {

    public CoffeePowder(double quantity) {
        super(Ingredient.IngredientEnum.COFFEE, quantity);
    }
}
