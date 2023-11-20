package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Floor {
    List<Slot> slots;
}
