# Parking-Lot

# Entities:
* Vehicle : Car, Motorcycle,Truck
* ParkingLot: Has Floors of parking slots
* Floor: Has parking slots
* Payments handler

# Functionalities:

* Park a vehicle
* Take out a vehicle
* Decide payment for the duration based on rules

### Flow

* Attempt to park a vehicle
* Starting point of the slot is determined and the start time is set
* If no slot available ,politely decline and continue to see if other vehicles can be parked
* A tracking ID is assigned to each vehicle and token passed on to the customer
* Customer uses tracking number to retrieve car
* Free up slot
