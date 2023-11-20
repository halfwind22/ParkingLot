package org.example.entities;

import java.util.List;

public interface Vehicle {
    void parkVehicle(List<Integer> parkingSlot);

    public int getWheels();
}
