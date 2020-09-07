package com.splitwise.models;

public class PercentSplit extends Split {

    double percentage;

    public PercentSplit(User u, double percent, double share){
        super(u);
        this.percentage = percent;
        super.setShareAmount(share);
    }
}
