import vehicletype.Vehicle;
import vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicletype;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicletype) {
        this.spotNumber = spotNumber;
        this.vehicletype = vehicletype;
    }
    public synchronized boolean isavailable() {
        return parkedVehicle == null;
    }
    public synchronized void parkVehicle(Vehicle vehicle) {
        // if(isavailable() && vehicletype == vehicle.getType())
            parkedVehicle = vehicle;
        // else
            // throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
    }
    public void unparkVehicle() {
        parkedVehicle = null;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    public VehicleType getVehicletype() {
        return vehicletype;
    }
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
