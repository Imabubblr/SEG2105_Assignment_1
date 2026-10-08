/**
 * Name: Henry Shi
 * Student ID: 300474640
 */

/** Represents a vehicle that travels on land. */
public class LandVehicle extends Vehicle {
    private static int numberOfLandVehicles = 0;

    /** Creates an unnamed land vehicle. */
    public LandVehicle() {
        super();
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor called");
    }

    /** Creates a named land vehicle. */
    public LandVehicle(String name) {
        super(name);
        numberOfLandVehicles++;
        System.out.println("LandVehicle Constructor with name called");
    }

    /** Moves the vehicle on land. */
    @Override
    public void move() {
        System.out.println("Rolling on land");
    }

    /** Returns the vehicle type. */
    @Override
    public String getVehicleType() {
        return "Land Vehicle";
    }

    /** Returns the total number of land vehicles created. */
    public static int getNumberOfLandVehicles() {
        return numberOfLandVehicles;
    }
}