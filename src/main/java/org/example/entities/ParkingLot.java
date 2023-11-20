package org.example.entities;

import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Map;


public class ParkingLot {

    @Getter
    private static Map<String, List<Integer>> parkingMemory;

    @Getter
    private final List<Floor> floors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }

    public static ParkingLot getInstanceOfParkingLot(List<Floor> floors) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(floors);
        }
        return parkingLot;
    }

    static void storeVehicleEntryInMemory(String carRegNumber, List<Integer> parkingSlot) {
        try {
            parkingMemory.put(carRegNumber, parkingSlot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Integer> retrieveVehicleEntryFromMemory(String carRegNumber) {
        return parkingMemory.getOrDefault(carRegNumber, null);
    }

    public void printParkingMap() {
        for (int floorNumber = 0; floorNumber < floors.size(); floorNumber++) {
            System.out.println("**************** FLOOR " + (floorNumber + 1) + " ****************");
            List<Slot> slots = floors.get(floorNumber).getSlots();
            for (int slotNumber = 0; slotNumber <= slots.size(); slotNumber++) {
                System.out.println("****** SLOT " + (slotNumber + 1) + "******");
                System.out.print("Status: " + slots.get(0).slotOccupancyStatus.toString() + " ");
                System.out.println("Occupied By:" + slots.get(0).occupancyId);
            }
        }
    }
}
