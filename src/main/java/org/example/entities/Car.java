package org.example.entities;

import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;

import java.util.List;

public class Car implements Vehicle {
    private final ParkingLot parkingLot;
    private final String carRegNumber;

    public Car(ParkingLot parkingLot, String carRegNumber) {
        this.parkingLot = parkingLot;
        this.carRegNumber = carRegNumber;
    }

    @Override
    public void parkVehicle(List<Integer> parkingSlot) {

        int floorId = parkingSlot.get(0);
        int startingSlotId = parkingSlot.get(1);
        List<Slot> slotsInFloor = parkingLot.getFloors().get(floorId).getSlots();
        for (int i = startingSlotId; i < startingSlotId + getWheels(); i++) {
            slotsInFloor.get(i).setVehicleType(VehicleType.CAR);
            slotsInFloor.get(i).setOccupancyId(carRegNumber);
            slotsInFloor.get(i).setSlotOccupancyStatus(SlotOccupancyStatus.BUSY);
        }

        ParkingLot.storeVehicleEntryInMemory(carRegNumber, parkingSlot);
    }

    @Override
    public int getWheels() {
        return 4;
    }
}
