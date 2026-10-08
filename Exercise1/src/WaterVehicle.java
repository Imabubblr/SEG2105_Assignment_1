/**
 * Name: Henry Shi
 * Student ID: 300474640
 */

/** Represents a vehicle that travels on water. */
public class WaterVehicle extends Vehicle {
    private static int numberOfWaterVehicles = 0;

    /** Creates an unnamed water vehicle. */
    public WaterVehicle() {
        super();
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor called");
    }

    /** Creates a named water vehicle. */
    public WaterVehicle(String name) {
        super(name);
        numberOfWaterVehicles++;
        System.out.println("WaterVehicle Constructor with name called");
    }

    /** Moves the vehicle on water. */
    @Override
    public void move() {
        System.out.println("Floating on water");
    }

    /** Returns the vehicle type. */
    @Override
    public String getVehicleType() {
        return "Water Vehicle";
    }

    /** Returns the total number of water vehicles created. */
    public static int getNumberOfWaterVehicles() {
        return numberOfWaterVehicles;
    }
}