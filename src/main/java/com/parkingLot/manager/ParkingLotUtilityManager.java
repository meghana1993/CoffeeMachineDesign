package com.parkingLot.manager;

import com.parkingLot.models.ParkingLot;
import com.parkingLot.models.ParkingTicket;
import com.parkingLot.models.Slot;
import com.parkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotUtilityManager {
   private static ParkingLotUtilityManager ourInstance = new ParkingLotUtilityManager();
   ParkingLot parkingLot;
   private Map<String, ParkingTicket> vehicleToParkingTicketMap = new HashMap<>();
   private Map<Integer, ParkingTicket> slotToParkingTicketMap = new HashMap<>();
   private ParkingLotUtilityManager() {
   }

   public static ParkingLotUtilityManager getInstance() {
      return ourInstance;
   }

   public void setParkingLot(ParkingLot parkingLot) {
      this.parkingLot = parkingLot;
   }

   public Slot parkVehicle(Vehicle vehicle) {
      ParkingTicket pt = vehicleToParkingTicketMap.getOrDefault(vehicle, null);
      if (pt == null) {
         Slot bookedSlot = this.parkingLot.getParkingSlot(vehicle);
         bookedSlot.setBooked(true);
         pt = new ParkingTicket(vehicle, bookedSlot);
         vehicleToParkingTicketMap.put(vehicle.getRegistrationNo(), pt);
         slotToParkingTicketMap.put(bookedSlot.getSlotNumber(), pt);
         return bookedSlot;
      } else
         return pt.getSlot();

   }

   public void freeUpSlot(Vehicle vehicle) {

      ParkingTicket pt = vehicleToParkingTicketMap.getOrDefault(vehicle.getRegistrationNo(), null);
      if (pt != null) {
         Slot toBeFreed = pt.getSlot();
         toBeFreed.setBooked(false);
         slotToParkingTicketMap.remove(toBeFreed);
         vehicleToParkingTicketMap.remove(vehicle.getRegistrationNo());
      }

   }

   public void printParkingLotStatus() {
      for (Map.Entry<String, ParkingTicket> entry : vehicleToParkingTicketMap.entrySet()) {
         System.out.println("Vehicle==" + entry.getKey() + "   " + "Slot number==" + entry.getValue().getSlot().getSlotNumber());
      }
//      this.slotToParkingTicketMap
   }


}
