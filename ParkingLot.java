import java.util.ArrayList;
import java.util.List;

import vehicletype.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if(instance  == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkedVehicle(Vehicle vehicle) {
        for(Level level : levels) {
            if(level.parkedVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully");
                return true;
            }
        }
        System.out.println("Could not park Vehicle");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for(Level level : levels) {
            if(level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
    public void displayAvailability() {
        for(Level level : levels) {
            level.displayAvailability();
        }
    }
}
