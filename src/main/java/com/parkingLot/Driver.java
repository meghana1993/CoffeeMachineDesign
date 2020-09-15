package com.parkingLot;

import com.parkingLot.manager.ParkingLotUtilityManager;
import com.parkingLot.models.Car;
import com.parkingLot.models.SimpleParkingLot;
import com.parkingLot.models.Vehicle;
import com.parkingLot.strategy.NearestSlotSelectionStrategy;

public class Driver {

   public static void main(String[] args) {
      ParkingLotUtilityManager pm = ParkingLotUtilityManager.getInstance();
      pm.setParkingLot(new SimpleParkingLot(10, new NearestSlotSelectionStrategy()));
      Vehicle vehicle1 = new Car("veh1", "black");
      Vehicle vehicle2 = new Car("veh2", "black");
      Vehicle vehicle3 = new Car("veh3", "black");
      pm.parkVehicle(vehicle1);
      pm.parkVehicle(vehicle2);
      pm.parkVehicle(vehicle3);
      pm.printParkingLotStatus();
      pm.freeUpSlot(vehicle1);
      pm.printParkingLotStatus();
      Vehicle vehicle4 = new Car("veh4", "black");
      pm.parkVehicle(vehicle4);
      pm.printParkingLotStatus();
   }
}
