package com.machine.coffeemaker.models;

public class Water extends Ingredient {

    public Water(double quantity) {
        super(Ingredient.IngredientEnum.WATER, quantity);
    }
}
