package com.machine.coffeemaker;

import com.machine.coffeemaker.service.CoffeeMakerManager;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CoffeeMakerManager manager = new CoffeeMakerManager();

        manager.stockUp(1, 10);
        manager.stockUp(2, 10);
        manager.stockUp(3, 10);
        manager.stockUp(4, 10);
        manager.stockUp(5, 10);
        manager.stockUp(6, 10);
        manager.stockUp(7, 10);
        manager.stockUp(8, 10);
        while(true) {
            System.out.println("1.Display Menu");
            System.out.println("2.Display Stock Status");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.println(manager.printMenu());
                System.out.println("Choose Beverage:  ");
                int selectedOption = sc.nextInt();

                if(selectedOption >=1 && selectedOption <=6) {
                    manager.prepareBeverage(selectedOption);
                }else{
                    System.out.println("Invalid");
                }
            } else if( input ==2) {
                System.out.println(manager.printStockStatus());
                System.out.println("R Refill");
                System.out.println("Q Exit");
                String selectedOption = sc.next();

                if(selectedOption.equalsIgnoreCase("r")){
                    int selectedIngredient = sc.nextInt();
                    double quantity = sc.nextDouble();

                    double updatedStock = manager.stockUp(selectedIngredient,quantity);
                    System.out.println("Updated Stock == "+ updatedStock);
                }else if( selectedOption.equalsIgnoreCase("q")){
                    break;
                }
            }else{
                System.out.println("Invalid.");
            }

        }





    }
}
