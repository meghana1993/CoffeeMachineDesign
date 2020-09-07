package com.splitwise.models;

public class EqualSplit extends Split {
//    double shareAmount;

    public EqualSplit(User u, double amount){
        super( u);
        super.setShareAmount(amount);
    }
}
