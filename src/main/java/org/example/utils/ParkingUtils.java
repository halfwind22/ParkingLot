package org.example.utils;

import org.example.entities.Floor;
import org.example.entities.Slot;
import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingUtils<T extends VehicleType> {

    public static Slot slotGenerator() {
        return new Slot(null, null, SlotOccupancyStatus.FREE);
    }

    public static Floor floorGenerator(int numberOfSlots) {

        List<Slot> listOfSlots = new ArrayList<>();
        for (int slot = 0; slot < numberOfSlots; slot++) {
            listOfSlots.add(slotGenerator());
        }
        return new Floor(listOfSlots);
    }

}
