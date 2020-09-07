package com.splitwise;

import com.splitwise.models.User;
import com.splitwise.service.ExpenseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        ExpenseServiceImpl expenseService = ExpenseServiceImpl.getInstance();
        expenseService.addUser(new User(1,"abc@xyz.com","A","123456789"));
        expenseService.addUser(new User(2,"abc2@xyz.com","B","12996789"));
        expenseService.addUser(new User(3,"abc3@xyz.com","C","145656789"));
        expenseService.addUser(new User(4,"abc4@xyz.com","D","123006789"));
        List<Integer> listUsers = new ArrayList<>();
        listUsers.add(1);listUsers.add(2);listUsers.add(3);listUsers.add(4);
        try {
//            expenseService.addExpense(1, 100, listUsers, "EQUAL", new ArrayList<>());


            List<Integer> expenseDetails = new ArrayList<Integer>();
            expenseDetails.add(10);expenseDetails.add(20);expenseDetails.add(60);expenseDetails.add(10);
            expenseService.addExpense(1,100,listUsers,"EXACT", expenseDetails);
            expenseService.showBalances();
            System.out.println ("*******user 2 balance *******");
            expenseService.showBalanceOfUser(2);
        }catch (Exception e){
            System.out.println(e);
        }




    }
}
