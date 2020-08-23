package com.machine.coffeemaker.factory;

import com.machine.coffeemaker.models.*;

import java.util.ArrayList;
import java.util.List;

public class IngredientFactory {
    public static List<Ingredient> getIngredients(int beverageId) {

        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        switch (beverageId) {
            case 1: //coffee
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(4));
                ingredients.add(new CoffeePowder(3));
                break;
            case 2: //chocolate milk
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(4));
                ingredients.add(new ChocolatePowder(4));
                ingredients.add(new Water(1));
                break;
            case 3: // hot milk
                ingredients.add(new Milk(1));
                break;
            case 4: //hot water
                ingredients.add(new Water(1));
                break;
            case 5: //tea
                ingredients.add(new Sugar(2));
                ingredients.add(new Milk(2));
                ingredients.add(new TeaPowder(4));
                ingredients.add(new Water(2));
                break;
            default:

        }
        return ingredients;
    }
}
