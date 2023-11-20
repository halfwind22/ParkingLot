package org.example.entities;

import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;

import java.util.List;

public class Truck implements Vehicle {
    private final ParkingLot parkingLot;
    private final String truckRegNumber;

    public Truck(ParkingLot parkingLot, String truckRegNumber) {
        this.parkingLot = parkingLot;
        this.truckRegNumber = truckRegNumber;
    }

    public void parkVehicle(List<Integer> parkingSlot) {

        int floorId = parkingSlot.get(0);
        int startingSlotId = parkingSlot.get(1);
        List<Slot> slotsInFloor = parkingLot.getFloors().get(floorId).getSlots();
        for (int i = startingSlotId; i < startingSlotId + getWheels(); i++) {
            slotsInFloor.get(i).setVehicleType(VehicleType.TRUCK);
            slotsInFloor.get(i).setOccupancyId(truckRegNumber);
            slotsInFloor.get(i).setSlotOccupancyStatus(SlotOccupancyStatus.BUSY);
        }

        ParkingLot.storeVehicleEntryInMemory(truckRegNumber, parkingSlot);
    }


    @Override
    public int getWheels() {
        return 8;
    }
}
