package com.spiltwise.Exception;

public class InvalidExpenseException extends RuntimeException {

   public InvalidExpenseException(String message) {
      super(message);
   }
}
