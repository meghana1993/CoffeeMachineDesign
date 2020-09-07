package com.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Split {
    private String id;
    private User paidFor;
    private double shareAmount;

    public Split(User paidFor) {
        this.id = UUID.randomUUID().toString();
        this.paidFor = paidFor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getPaidFor() {
        return paidFor;
    }

    public void setPaidFor(User paidFor) {
        this.paidFor = paidFor;
    }

    public double getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(double shareAmount) {
        this.shareAmount = shareAmount;
    }
}
