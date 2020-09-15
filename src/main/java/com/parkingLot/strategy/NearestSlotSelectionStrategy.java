package com.parkingLot.strategy;

import com.parkingLot.exception.NoSlotFoundException;
import com.parkingLot.models.Slot;
import com.parkingLot.models.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NearestSlotSelectionStrategy implements SlotSelectionStrategy {

   public NearestSlotSelectionStrategy() {
   }

   @Override
   public Slot getParkingSlot(Vehicle v, List<Slot> slots) {

      Optional<Slot> availableSlot = slots.stream().sorted(Comparator.comparing(Slot::getSlotNumber)).filter(s ->
              !s.isBooked()).findFirst();
      if (availableSlot.isPresent()) {
         return availableSlot.get();
      }

      throw new NoSlotFoundException("No Slots!");
   }
}
