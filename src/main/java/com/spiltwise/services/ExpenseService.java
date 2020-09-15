package com.spiltwise.services;

import com.spiltwise.Exception.InvalidExpenseException;
import com.spiltwise.models.Expense;
import com.spiltwise.models.ExpenseType;
import com.spiltwise.models.User;

import java.util.List;

public interface ExpenseService {

   Expense addExpense(User paidBy, ExpenseType expenseType, double totalAmount, List<User> sharedAmoung, List<Double> expenseDetails) throws InvalidExpenseException;

   void showBalances();

   void showUserBalance(User u);

}
