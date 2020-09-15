package com.parkingLot.models;

import lombok.Getter;

@Getter
public class ParkingTicket {
   private Vehicle vehicle;
   private Slot slot;
   private Long timeStamp;

   public ParkingTicket(Vehicle vehicle, Slot slot) {
      this.vehicle = vehicle;
      this.slot = slot;
      this.timeStamp = System.currentTimeMillis();
   }
}
