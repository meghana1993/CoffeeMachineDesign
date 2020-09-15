package com.parkingLot.strategy;

import com.parkingLot.models.Slot;
import com.parkingLot.models.Vehicle;

import java.util.List;

public interface SlotSelectionStrategy {

   Slot getParkingSlot(Vehicle v, List<Slot> slots);
}
