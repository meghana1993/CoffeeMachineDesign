package com.parkingLot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Vehicle {
   private final String registrationNo;
   private final String color;
   private final VehicleType vehicleType;
}
