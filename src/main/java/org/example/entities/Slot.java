package org.example.entities;

import lombok.AllArgsConstructor;
import org.example.enums.SlotOccupancyStatus;

@AllArgsConstructor
public class Slot {

    String occupancyId;
    SlotOccupancyStatus slotOccupancyStatus;

}
