package com.machine.coffeemaker.service;

import com.machine.coffeemaker.enums.MenuEnum;
import com.machine.coffeemaker.models.Ingredient;
import com.machine.coffeemaker.repository.CoffeeMachineRepository;

import java.util.Map;

public class CoffeeMakerServiceImpl implements CoffeeMakerService{

    private static CoffeeMakerServiceImpl coffeeMakerServiceImpl;
    private static CoffeeMachineRepository coffeMachineRepo;

    public CoffeeMakerServiceImpl(){
        this.coffeMachineRepo = CoffeeMachineRepository.getInstance();

    }

    public static CoffeeMakerServiceImpl getInstance(){
        if(coffeeMakerServiceImpl == null){
            coffeeMakerServiceImpl = new CoffeeMakerServiceImpl();
        }
        return coffeeMakerServiceImpl;
    }

    @Override
    public Map<Integer, Double> getStockStatus() {
        return this.coffeMachineRepo.getStockStatus();
    }

    public MenuEnum[] getMenu(){
        MenuEnum[] menuItems = MenuEnum.values();
        return menuItems;

    }

    @Override
    public boolean dispenseBeverage(int bevId) {
        if(!canBeverageBeDispensed(bevId)) {
            return false;
        }

        MenuEnum beverageToBePrepared = null;
        for(MenuEnum menuItem : getMenu()){
            if(menuItem.getId() == bevId){
                beverageToBePrepared = menuItem;
                break;
            }
        }
        for(Ingredient ing : beverageToBePrepared.getListOfIngredients()){
            int ingId = ing.getIngredient().getId();
            double quantityNeded = ing.getQuantity();
            coffeMachineRepo.updateStock(ingId, -1*quantityNeded);
        }
        return true;
    }

    @Override
    public boolean canBeverageBeDispensed(int bevId) {
        MenuEnum beverageToBePrepared = null;
        for(MenuEnum menuItem : getMenu()){
            if(menuItem.getId() == bevId){
                beverageToBePrepared = menuItem;
                break;
            }
        }
        for(Ingredient ing : beverageToBePrepared.getListOfIngredients()){
            int ingId = ing.getIngredient().getId();
            double quantityNeded = ing.getQuantity();
            if(! coffeMachineRepo.ingredientAvailable(ingId, quantityNeded)){
                return false;
            }
        }
        return true;
    }

    @Override
    public double stockUp(int selectedIngredient, double toUpQuantity) {
        return coffeMachineRepo.updateStock(selectedIngredient, toUpQuantity);
    }

}
