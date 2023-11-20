package org.example.entities;

import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;

import java.util.List;

public class MotorCycle implements Vehicle {
    private final ParkingLot parkingLot;
    private final String bikeRegNumber;

    public MotorCycle(ParkingLot parkingLot, String bikeRegNumber) {
        this.parkingLot = parkingLot;
        this.bikeRegNumber = bikeRegNumber;
    }

    @Override
    public void parkVehicle(List<Integer> parkingSlot) {

        int floorId = parkingSlot.get(0);
        int startingSlotId = parkingSlot.get(1);
        List<Slot> slotsInFloor = parkingLot.getFloors().get(floorId).getSlots();
        for (int i = startingSlotId; i < startingSlotId + getWheels(); i++) {
            slotsInFloor.get(i).setVehicleType(VehicleType.MOTORCYCLE);
            slotsInFloor.get(i).setOccupancyId(bikeRegNumber);
            slotsInFloor.get(i).setSlotOccupancyStatus(SlotOccupancyStatus.BUSY);
        }

        ParkingLot.storeVehicleEntryInMemory(bikeRegNumber, parkingSlot);
    }

    @Override
    public int getWheels() {
        return 2;
    }
}
