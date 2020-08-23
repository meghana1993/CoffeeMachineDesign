//package com.machine.coffeemaker.enums;
//
//import com.machine.coffeemaker.models.Ingredient;
//
//public enum IngredientEnum {
//    SUGAR(1,"SUGAR"), WATER(2,"WATER"), TEA(3,"TEA"), COFFEE(4,"COFFEE"), CHOCOLATE(5,"CHOCOLATE"),MILK(6,"MILK");
//
//    private String name;
//    private int id;
//
//    IngredientEnum(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public static String getName(int id) {
//        for (IngredientEnum ing : IngredientEnum.values()) {
//            if (ing.getId() == id) {
//                return ing.getName();
//            }
//        }
//        return null;
//    }
//}
