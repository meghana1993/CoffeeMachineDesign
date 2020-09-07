package com.splitwise.models;

public class ExactSplit extends Split {


    public ExactSplit(User u, double amount){
        super( u);
        super.setShareAmount(amount);
    }
}
