package com.parkingLot.exception;

public class NoSlotFoundException extends RuntimeException {

   public NoSlotFoundException(String message) {
      super(message);
   }
}
