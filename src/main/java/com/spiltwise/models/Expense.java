package com.spiltwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Expense {
   private String expenseId;
   private User paidBy;
   private double totalAmount;
   private List<Share> usersShare;

   public Expense(User paidBy, double totalAmount, List<Share> share) {
      this.expenseId = UUID.randomUUID().toString();
      this.paidBy = paidBy;
      this.totalAmount = totalAmount;
      this.usersShare = share;
   }


   public abstract boolean validateSplits();
}
