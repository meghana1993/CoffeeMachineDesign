package com.spiltwise.services;

import com.spiltwise.Exception.InvalidExpenseException;
import com.spiltwise.models.*;
import com.spiltwise.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {
   private static ExpenseServiceImpl expenseServiceImpl;

   public static ExpenseServiceImpl getInstance() {
      if (expenseServiceImpl == null) {
         expenseServiceImpl = new ExpenseServiceImpl();
      }
      return expenseServiceImpl;
   }

   @Override
   public Expense addExpense(User paidBy, ExpenseType expenseType, double totalAmount, List<User> sharedAmoung, List<Double> expenseDetails) throws InvalidExpenseException {
      List<Share> userShare = new ArrayList<>();
      Expense expense = null;
      if (expenseType.equals(ExpenseType.PERCENT)) {
         for (int i = 0; i < sharedAmoung.size(); i++) {
            userShare.add(new PercentShare(sharedAmoung.get(i), expenseDetails.get(i), totalAmount));
         }
         expense = new PercentExpense(paidBy, totalAmount, userShare);

      } else if (expenseType.equals(ExpenseType.EXACT)) {
         for (int i = 0; i < sharedAmoung.size(); i++) {
            userShare.add(new ExactShare(sharedAmoung.get(i), expenseDetails.get(i)));
         }
         expense = new ExactExpense(paidBy, totalAmount, userShare);

      } else {
         for (int i = 0; i < sharedAmoung.size(); i++) {
            double share = ((double) Math.round(totalAmount * 100 / (sharedAmoung.size()))) / 100.0;
            userShare.add(new EqualShare(sharedAmoung.get(i), share));
         }
         expense = new EqualExpense(paidBy, totalAmount, userShare);

      }
      if (!expense.validateSplits()) {
         throw new InvalidExpenseException("Invalid Expense.The Shares dont add up to the total amount please verify!!");
      }
      ExpenseRepository.getInstance().addExpense(expense);
      return expense;
   }

   @Override
   public void showBalances() {
      Map<String, Map<String, Double>> balanceSheet = ExpenseRepository.getInstance().getBalances();
      for (Map.Entry<String, Map<String, Double>> userBalance : balanceSheet.entrySet()) {
         for (Map.Entry<String, Double> paidedForUser : userBalance.getValue().entrySet()) {
            System.out.println(ExpenseRepository.getInstance().getUserFromEmailId(paidedForUser.getKey()).getName() + "  owes " +
                    ExpenseRepository.getInstance().getUserFromEmailId(userBalance.getKey()).getName() + "   " + paidedForUser.getValue());
         }
      }

   }

   @Override
   public void showUserBalance(User u) {
      Map<String, Double> userBalance = ExpenseRepository.getInstance().getUserBalance(u);
      for (Map.Entry<String, Double> paidedForUser : userBalance.entrySet()) {
         System.out.println(ExpenseRepository.getInstance().getUserFromEmailId(paidedForUser.getKey()).getName() + "  owes  " + u.getName()
                 + "   " + paidedForUser.getValue());
      }

   }

   public void addUser(User u) {
      ExpenseRepository.getInstance().addUser(u);
   }
}
