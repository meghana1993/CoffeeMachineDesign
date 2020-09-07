package com.splitwise.models;

import java.util.List;

public class PercentExpense extends Expense {

    public PercentExpense(User u, double totalAmount, List<Split> splits ){
        super(u, totalAmount,splits);
    }

    @Override
    public boolean validate() {
        for(Split s: getSplits()){
          if(! (s instanceof PercentSplit)){
              return false;
          }
        }
        return true;
    }
}
