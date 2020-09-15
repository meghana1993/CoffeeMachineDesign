package com.spiltwise.Exception;

public class InvalidUser extends RuntimeException {

   public InvalidUser(String message) {
      super(message);
   }
}
