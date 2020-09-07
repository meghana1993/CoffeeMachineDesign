package com.splitwise.repository;

import com.splitwise.models.Expense;
import com.splitwise.models.Split;
import com.splitwise.models.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {

    private Map<Integer, Map<Integer, Double>> balanceSheet = new HashMap<>();
    private Map<Integer, User> userMap = new HashMap<>();
    private List<Expense> allExpenses;

    private static ExpenseRepository expenseRepository;

    public static ExpenseRepository getInstance(){
        if(expenseRepository == null){
            expenseRepository = new ExpenseRepository();
        }
        return expenseRepository;
    }

    public ExpenseRepository(){
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.allExpenses = new ArrayList<>();
    }

    public User getUserFromId(int id) throws Exception{
        if(userMap.get(id) != null){
            return userMap.get(id);
        }else{
            throw new Exception("Invalid User");
        }
    }

    public void addExpense(Expense expense){
        allExpenses.add(expense);
        List<Split> splits = expense.getSplits();
        int userId = expense.getPaidBy().getId();
        //get relation of paidByuser with all users


        //updated the relation based on splits list
        for(Split s: splits){
            Map<Integer, Double> expenseMap = balanceSheet.getOrDefault(userId, new HashMap<>());
            double currentExpense = expenseMap.getOrDefault(s.getPaidFor().getId(), 0d);
            expenseMap.put(s.getPaidFor().getId(), currentExpense+ s.getShareAmount());
            balanceSheet.put(userId, expenseMap);


            //updated map for the second user also
            expenseMap = balanceSheet.getOrDefault(s.getPaidFor().getId(), new HashMap<>());
            double otherUsercurrentExpense = expenseMap.getOrDefault(userId, 0d);
            expenseMap.put(userId, otherUsercurrentExpense - s.getShareAmount());
            balanceSheet.put(s.getPaidFor().getId(),expenseMap);
        }

    }

    public Map<Integer, Double> getBalanceById(int id) throws Exception{
        Map<Integer, Double> balance = new HashMap<>();
                if(balanceSheet.get(id) != null){
                    balance = balanceSheet.get(id);
                }

        return balance;
    }

    public Map<Integer, Map<Integer, Double>> getBalanceSheet(){
        return balanceSheet;
    }

    public void addUser(User u){
        userMap.put(u.getId(), u);
    }

}
