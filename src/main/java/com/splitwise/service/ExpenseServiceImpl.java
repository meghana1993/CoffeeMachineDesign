package com.splitwise.service;

import com.splitwise.models.*;
import com.splitwise.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {

    private static ExpenseRepository expenseRepository;
    private static ExpenseServiceImpl expenseServiceImpl;

    public ExpenseServiceImpl(){
        expenseRepository = ExpenseRepository.getInstance();
    }

    public static ExpenseServiceImpl getInstance(){
        if(expenseServiceImpl == null){
            expenseServiceImpl = new ExpenseServiceImpl();
        }
        return expenseServiceImpl;
    }

    @Override
    public Expense addExpense(int paidBy, double totalAmount, List<Integer> sharedAmong, String expenseType, List<Integer> expenseDetails) throws Exception {
        List<Split> splits = new ArrayList<>();
        Expense expense = null;

        User paidByUser = expenseRepository.getUserFromId(paidBy);
        if(expenseType.equalsIgnoreCase("EQUAL")){

            double share = ((double) Math.round(totalAmount*100/(sharedAmong.size())))/100.0;
            double extra =0d;
            if(totalAmount % (sharedAmong.size()+1) != 0){
                 extra = totalAmount - (share)*(sharedAmong.size()) ;
            }

            for(Integer i : sharedAmong){
                    splits.add(new EqualSplit(expenseRepository.getUserFromId(i), share));
            }
            splits.get(0).setShareAmount(splits.get(0).getShareAmount()+ extra);

            expense = new EqualExpense(paidByUser, totalAmount, splits);
        }

        else if(expenseType.equalsIgnoreCase("PERCENT")){
            double sum =0d;

            for(Integer i : sharedAmong){
                double share = (totalAmount*expenseDetails.get(i-1)/100);
                splits.add(new PercentSplit(expenseRepository.getUserFromId(i), expenseDetails.get(i-1),share));
                sum += share;
            }
            splits.get(0).setShareAmount(splits.get(0).getShareAmount()+ totalAmount - sum);
             expense = new PercentExpense(paidByUser, totalAmount,splits );
        }else{
            for(Integer i : sharedAmong){
                double share = expenseDetails.get(i-1);
                splits.add(new ExactSplit(expenseRepository.getUserFromId(i),share));
            }

            expense = new ExactExpense(paidByUser, totalAmount,splits );

        }


        expenseRepository.addExpense(expense);
        return expense;
    }

    @Override
    public void showBalances() throws Exception{
        Map<Integer, Map<Integer, Double>> balanceSheet = expenseRepository.getBalanceSheet();
        for(Map.Entry<Integer, Map<Integer, Double>> allbalances : balanceSheet.entrySet()){
            for(Map.Entry<Integer, Double> userBalance : allbalances.getValue().entrySet()){
                    System.out.println(expenseRepository.getUserFromId(userBalance.getKey()).getName()+ " owes "+userBalance.getValue()+" to " + expenseRepository.getUserFromId(allbalances.getKey()).getName());
            }
        }
    }

    @Override
    public void showBalanceOfUser(int userId) throws Exception {

        for(Map.Entry<Integer, Double> balance : expenseRepository.getBalanceById(userId).entrySet() ){
                System.out.println(expenseRepository.getUserFromId(balance.getKey()).getName()+ " owes "+ balance.getValue() +" to "+ expenseRepository.getUserFromId(userId).getName());
        }


    }

    public void addUser(User u){
        expenseRepository.addUser(u);
    }
}
