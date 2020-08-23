package com.machine.coffeemaker.service;

import com.machine.coffeemaker.enums.MenuEnum;
import com.machine.coffeemaker.models.Ingredient;

import java.util.Map;

public class CoffeeMakerManager {
    private CoffeeMakerServiceImpl coffeeMakerServiceImpl;

    public CoffeeMakerManager(){
        this.coffeeMakerServiceImpl = CoffeeMakerServiceImpl.getInstance();
    }

    public String printMenu(){
        StringBuilder str = new StringBuilder("");
        MenuEnum[] menuItems = coffeeMakerServiceImpl.getMenu();
        for(MenuEnum menuItem : menuItems){
            str.append(menuItem.getId());
            str.append(".");
            str.append(menuItem.getName());
            str.append(":");
            str.append(menuItem.getPrice());
            str.append('\n');
    }
     return str.toString();

    }

    public void prepareBeverage(int bevId){
        boolean isAvailable = this.coffeeMakerServiceImpl.dispenseBeverage(bevId);
        if(isAvailable){
            System.out.println("Dispensing....");
        }else{
            System.out.println("Out of Stock!!");
        }
    }

    public String printStockStatus(){
        Map<Integer, Double> ingredientMap = this.coffeeMakerServiceImpl.getStockStatus();
        StringBuilder str = new StringBuilder("");
        for(Map.Entry<Integer, Double> ing : ingredientMap.entrySet()){
            str.append(ing.getKey());
            str.append(".");
            str.append(Ingredient.IngredientEnum.getName(ing.getKey()));
            str.append(":");
            str.append(ing.getValue());
            str.append('\n');
        }


        return str.toString();
    }

    public double stockUp(int ingId, double quantity){
        return this.coffeeMakerServiceImpl.stockUp(ingId, quantity);
    }

}
