package com.spiltwise.models;

import java.util.List;

public class PercentExpense extends Expense {


   public PercentExpense(User paidBy, double totalAmount, List<Share> share) {
      super(paidBy, totalAmount, share);
   }

   @Override
   public boolean validateSplits() {
      int total = 0;
      double totalSum = 0d;
      for (int i = 0; i < this.getUsersShare().size(); i++) {
         PercentShare ps = (PercentShare) this.getUsersShare().get(i);
         total += ps.getPercent();
         totalSum += ps.getShare();
      }
      if (total != 100) {
         return false;
      }
      double extra = this.getTotalAmount() - totalSum;
      this.getUsersShare().get(0).setShare(this.getUsersShare().get(0).getShare() + extra);
      return true;
   }
}
