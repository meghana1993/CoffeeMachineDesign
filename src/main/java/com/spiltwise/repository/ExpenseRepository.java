package com.spiltwise.repository;

import com.spiltwise.Exception.InvalidUser;
import com.spiltwise.models.Expense;
import com.spiltwise.models.Share;
import com.spiltwise.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
   private static ExpenseRepository ourInstance = new ExpenseRepository();
   Map<String, Map<String, Double>> balanceSheet;
   Map<String, User> userMap;
   List<Expense> allExpenses;

   private ExpenseRepository() {
      this.allExpenses = new ArrayList<>();
      this.balanceSheet = new HashMap<>();
      this.userMap = new HashMap<>();
   }

   public static ExpenseRepository getInstance() {
      return ourInstance;
   }

   public void addExpense(Expense expense) {
      User paidBy = expense.getPaidBy();
      List<Share> userShare = expense.getUsersShare();
      Map<String, Double> userbalance = this.balanceSheet.getOrDefault(paidBy, new HashMap<>());
      for (int i = 0; i < userShare.size(); i++) {
         double existingbalance = userbalance.getOrDefault(userShare.get(i).getShareOwner(), 0d);
         existingbalance += userShare.get(i).getShare();
         userbalance.put(userShare.get(i).getShareOwner().getEmailId(), existingbalance);

         Map<String, Double> userbalance1 = this.balanceSheet.getOrDefault(userShare.get(i).getShareOwner(), new HashMap<>());
         double existingBalance1 = userbalance1.getOrDefault(paidBy, 0d);
         existingBalance1 -= userShare.get(i).getShare();
         userbalance1.put(paidBy.getEmailId(), existingBalance1);
         this.balanceSheet.put(userShare.get(i).getShareOwner().getEmailId(), userbalance1);
      }
      this.balanceSheet.put(paidBy.getEmailId(), userbalance);

   }

   public Map<String, Map<String, Double>> getBalances() {
      return this.balanceSheet;
   }

   public Map<String, Double> getUserBalance(User u) {
      return this.balanceSheet.getOrDefault(u, new HashMap<>());
   }

   public void addUser(User u) {
      if (!this.userMap.containsKey(u.getEmailId())) {
         this.userMap.put(u.getEmailId(), u);
      }
   }

   public User getUserFromEmailId(String emailId) {
      if (this.userMap.containsKey(emailId)) {
         return this.userMap.get(emailId);
      } else {
         throw new InvalidUser("Invalid User");
      }
   }


}
