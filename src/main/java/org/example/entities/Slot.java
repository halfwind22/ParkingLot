package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.SlotOccupancyStatus;
import org.example.enums.VehicleType;

@AllArgsConstructor
@Data
public class Slot {

    VehicleType vehicleType;
    String occupancyId;
    SlotOccupancyStatus slotOccupancyStatus;

}
