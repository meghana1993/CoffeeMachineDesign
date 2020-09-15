package com.parkingLot.models;

public class Car extends Vehicle {

   public Car(String registrationNo, String color) {
      super(registrationNo, color, VehicleType.CAR);
   }
}
