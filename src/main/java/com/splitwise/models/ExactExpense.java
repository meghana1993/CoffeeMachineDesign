package com.splitwise.models;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(User u, double totalAmount, List<Split> splits ){
        super(u, totalAmount,splits);
    }

    @Override
    public boolean validate() {
        for(Split s: getSplits()){
          if(! (s instanceof EqualSplit)){
              return false;
          }
        }
        return true;
    }
}
