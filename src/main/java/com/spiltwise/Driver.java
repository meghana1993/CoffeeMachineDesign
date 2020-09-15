package com.spiltwise;

import com.spiltwise.models.ExpenseType;
import com.spiltwise.models.User;
import com.spiltwise.services.ExpenseServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Driver {

   public static void main(String[] args) {
      ExpenseServiceImpl expenseService = ExpenseServiceImpl.getInstance();
      User u1 = new User("Meghana", "Meghana1993@gmail.com", "45667857755");
      expenseService.addUser(u1);
      User u2 = new User("Meghana1", "Meghana19931@gmail.com", "45660077755");
      expenseService.addUser(u2);
      User u3 = new User("Meghana2", "Meghana19932@gmail.com", "45612677755");
      expenseService.addUser(u3);
      User u4 = new User("Meghana3", "Meghana19933@gmail.com", "45645677755");
      expenseService.addUser(u4);
      User u5 = new User("Meghana4", "Meghana19943@gmail.com", "45667897755");
      expenseService.addUser(u5);

      List<User> sharedAmoung = new ArrayList<>();
      sharedAmoung.add(u1);
      sharedAmoung.add(u2);
      sharedAmoung.add(u3);
      sharedAmoung.add(u4);
      List<Double> expenseDetails = new ArrayList<>();
      expenseDetails.add(10d);
      expenseDetails.add(20d);
      expenseDetails.add(50d);
      expenseDetails.add(20d);
      expenseService.addExpense(u1, ExpenseType.EXACT, 100, sharedAmoung, expenseDetails);
      expenseService.showBalances();

   }
}
