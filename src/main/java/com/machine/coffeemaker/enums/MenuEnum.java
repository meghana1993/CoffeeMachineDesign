package com.machine.coffeemaker.enums;

import com.machine.coffeemaker.factory.IngredientFactory;
import com.machine.coffeemaker.models.Ingredient;

import java.util.List;

public enum MenuEnum {


    Coffee(1, "Coffee"),
    TEA(2, "TEA"),
    HOTCHOCOLATE(3, "Hot Chocolate"),
    MILK(4, "Milk"),
    HOTWATER(5, "Hot Water"),
    ICEDTEA(6,"Iced Tea");

    private int id;
    private String name;
    private List<Ingredient> listOfIngredients;
    private double price;


    MenuEnum(int id, String name) {
        this.id = id;
        this.name = name;
        this.listOfIngredients= IngredientFactory.getIngredients(id);
        this.price = calculatePrice(listOfIngredients);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(List<Ingredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculatePrice(List<Ingredient> ingredients) {
        double cost = 0d;
        for (Ingredient ing : ingredients) {
            cost += ing.getQuantity() * ing.getIngredient().getPrice();
        }
        return cost;
    }


}
