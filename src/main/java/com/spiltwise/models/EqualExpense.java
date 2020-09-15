package com.spiltwise.models;

import java.util.List;

public class EqualExpense extends Expense {

   public EqualExpense(User paidBy, double totalAmount, List<Share> share) {
      super(paidBy, totalAmount, share);
   }


   @Override
   public boolean validateSplits() {
      double total = 0;
      for (int i = 0; i < this.getUsersShare().size(); i++) {
         total += this.getUsersShare().get(i).getShare();
      }
      double extra = this.getTotalAmount() - total;
      this.getUsersShare().get(0).setShare(this.getUsersShare().get(0).getShare() + extra);
      return true;
   }
}
