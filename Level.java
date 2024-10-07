import java.util.ArrayList;
import java.util.List;

import vehicletype.Vehicle;
import vehicletype.VehicleType;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;
    
    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        int numMotorCycles = (int)0.2*numSpots;
        int numCars = (int)0.4*numSpots;
        int numTrucks = (int)0.4*numSpots;

        for(int i = 1; i <= numMotorCycles; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }
        for(int i = 1 + numMotorCycles; i <= numMotorCycles + numCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for(int i = 1 + numMotorCycles + numCars; i <= numMotorCycles + numCars + numTrucks; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkedVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isavailable() && vehicle.getType() == spot.getVehicletype()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(!spot.isavailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }
    public void displayAvailability() {
        System.out.println("Level: " + floor + " Availability: ");
        for(ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + " : " + (spot.isavailable() ? "Available for: " : "Occupied by: " + spot.getVehicletype()));
        }
    }
}
