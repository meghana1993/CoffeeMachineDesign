package com.parkingLot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Slot {
   private int slotNumber;
   private boolean isBooked;

   public Slot(int slotNumber) {
      this.slotNumber = slotNumber;
      this.isBooked = false;
   }
}
