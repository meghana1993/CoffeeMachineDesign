package com.machine.coffeemaker.repository;

import com.machine.coffeemaker.models.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachineRepository {
    private HashMap<Integer,Double> ingredientsHashMap  = new HashMap<>();

    private static CoffeeMachineRepository coffeeMachineRepo;

    public CoffeeMachineRepository(){
    }

    public static CoffeeMachineRepository getInstance(){
        if(coffeeMachineRepo == null){
            coffeeMachineRepo = new CoffeeMachineRepository();
        }
        return coffeeMachineRepo;
    }

    public double getStock(int ingId){
        return ingredientsHashMap.get(ingId);

    }

    public double updateStock(int ingId, double value){

        double curValue = ingredientsHashMap.getOrDefault(ingId, 0d);
        ingredientsHashMap.put(ingId,curValue+value);
        return curValue+value;
    }

    public Map<Integer,Double> getStockStatus(){
        return ingredientsHashMap;
    }

    public boolean ingredientAvailable(int ingId, double needed){
        return ingredientsHashMap.getOrDefault(ingId, 0d) >= needed ;
    }
}
