package com.splitwise.service;

import com.splitwise.models.Expense;
import com.splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface ExpenseService {

     Expense addExpense(int paidBy, double totalAmount, List<Integer> sharedAmong , String expenseType, List<Integer> expenseDetails) throws Exception;
     void showBalances() throws Exception;
     void showBalanceOfUser(int userId) throws Exception;

}
