package com.splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense( User u, double totalAmount, List<Split> splits ){
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
