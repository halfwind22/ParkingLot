package org.example.service;

import org.example.entities.Floor;
import org.example.entities.ParkingLot;
import org.example.entities.Slot;
import org.example.entities.Vehicle;
import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;
import org.example.exceptions.VehicleNotFoundException;

import java.util.*;

public class ParkingService<T extends Vehicle> {
    private final ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    void park(T vehicle) {

        List<Integer> parkingSlot = checkForFreeSlots(vehicle.getWheels()).orElseThrow();
        vehicle.parkVehicle(parkingSlot);
        System.out.println("Vehicle has been parked!, printing layout");
        parkingLot.printParkingMap();

    }

    void unPark(String regNum) {
        List<Integer> startingFloorSlot = parkingLot.retrieveVehicleEntryFromMemory(regNum);
        if (startingFloorSlot != null) {
            List<Slot> parkingSlotList = parkingLot.getFloors().get(startingFloorSlot.indexOf(0)).getSlots();

            Slot occupiedSlot = parkingSlotList.get(startingFloorSlot.get(1));
            VehicleType vehicleType = occupiedSlot.getVehicleType();

            int index = parkingSlotList.indexOf(occupiedSlot);
            while (occupiedSlot.getVehicleType() == vehicleType) {
                occupiedSlot.setSlotOccupancyStatus(SlotOccupancyStatus.FREE);
                occupiedSlot.setOccupancyId(null);
                occupiedSlot.setVehicleType(null);
                index += 1;
                occupiedSlot = parkingSlotList.get(index);
            }

            System.out.println("Parking status has been updated!");
            parkingLot.printParkingMap();

        }
        throw new VehicleNotFoundException("Vehicle bearing registration number: " + regNum + "could not be found!");
    }

    Optional<List<Integer>> checkForFreeSlots(int desiredSlotSize) {

        // Check if a slot of size `desiredSlotSize` free.
        // return floor number and slot number if available
        //else return -1,-1

        for (Floor floor : parkingLot.getFloors()) {
            int parkingPositionFound = 0;
            Slot startingSlot = null;
            for (Slot slot : floor.getSlots()) {
                if (slot.getSlotOccupancyStatus().equals(SlotOccupancyStatus.BUSY)) {
                    parkingPositionFound = 0;
                    startingSlot = null;

                } else {
                    if (startingSlot == null) {
                        startingSlot = slot;
                    }
                    parkingPositionFound += 1;
                    if (parkingPositionFound == desiredSlotSize) {
                        return Optional.of(List.of(parkingLot.getFloors().indexOf(floor), floor.getSlots().indexOf(startingSlot)));
                    }
                }
            }
        }
        return Optional.empty();
    }
}
