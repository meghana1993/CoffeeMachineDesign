package com.spiltwise.models;

import java.util.List;

public class ExactExpense extends Expense {


   public ExactExpense(User paidBy, double totalAmount, List<Share> share) {
      super(paidBy, totalAmount, share);
   }

   @Override
   public boolean validateSplits() {

      double total = 0d;
      for (int i = 0; i < this.getUsersShare().size(); i++) {
         total += this.getUsersShare().get(i).getShare();
      }
      if (total != this.getTotalAmount())
         return false;

      return true;
   }
}
