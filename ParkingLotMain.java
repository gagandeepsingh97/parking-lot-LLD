import vehicletype.Car;
import vehicletype.MotorCycle;
import vehicletype.Truck;
import vehicletype.Vehicle;

public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 50));

        Vehicle car1 = new Car("C123");
        Vehicle motorCycle1 = new MotorCycle("MC456");
        Vehicle truck1 = new Truck("T789");
        Vehicle car2 = new Car("C223");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(motorCycle1);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(car2);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(car1);
        parkingLot.unparkVehicle(truck1);

        parkingLot.displayAvailability();
    }
}
