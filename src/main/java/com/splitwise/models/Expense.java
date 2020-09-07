package com.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public abstract class Expense {
    private String id;
    private User paidBy;
    private double totalAmount;
    private List<Split> splits;

    public Expense(User paidBy, double totalAmount , List<Split> splits ) {
        this.id = UUID.randomUUID().toString();
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.splits = splits;
    }

    public abstract boolean validate();

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }
}
