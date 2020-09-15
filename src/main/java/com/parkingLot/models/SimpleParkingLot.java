package com.parkingLot.models;

import com.parkingLot.strategy.SlotSelectionStrategy;

import java.util.ArrayList;

public class SimpleParkingLot extends ParkingLot {
   private final SlotSelectionStrategy strategy;


   public SimpleParkingLot(int noOfSlots, SlotSelectionStrategy strategy) {
      super();
      this.slots = new ArrayList<>();

      for (int i = 0; i < noOfSlots; i++) {
         this.slots.add(new SimpleSlot(i + 1));
      }
      this.strategy = strategy;
   }

   @Override
   public Slot getParkingSlot(Vehicle v) {
      return this.strategy.getParkingSlot(v, this.slots);
   }
}
