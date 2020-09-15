package com.parkingLot.models;

import java.util.List;

public abstract class ParkingLot {
   protected List<Slot> slots;

   public ParkingLot() {

   }

   public abstract Slot getParkingSlot(Vehicle v);


}
