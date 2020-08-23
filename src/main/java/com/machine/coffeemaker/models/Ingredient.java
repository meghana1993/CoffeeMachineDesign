package com.machine.coffeemaker.models;


public class Ingredient {

    private IngredientEnum ingredient;
    private double quantity;

    public Ingredient(IngredientEnum ingredientName, double quantity) {
        this.quantity = quantity;
        this.ingredient = ingredientName;
    }

    public IngredientEnum getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEnum ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public enum IngredientEnum {
        SUGAR(1, "SUGAR", 7), WATER(2, "WATER", 1), TEA(3, "TEA", 10), COFFEE(4, "COFFEE", 15),
        CHOCOLATE(5, "CHOCOLATE", 20), MILK(6, "MILK", 15 ), CREAM(7, "CREAM", 30), LEMON(8,"LEMON", 10);

        private String name;
        private int id;
        private double price;

        IngredientEnum(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public static String getName(int id) {
            for (Ingredient.IngredientEnum ing : Ingredient.IngredientEnum.values()) {
                if (ing.getId() == id) {
                    return ing.getName();
                }
            }
            return null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
