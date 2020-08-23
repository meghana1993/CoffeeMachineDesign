package com.machine.coffeemaker.models;

public class Sugar extends Ingredient {

    public Sugar(double quantity) {
        super(Ingredient.IngredientEnum.SUGAR, quantity);
    }
}
