/** Represents a sailboat, which is a water vehicle. */
public class Sailboat extends WaterVehicle {
    /** Creates an unnamed sailboat. */
    public Sailboat() {
        super();
        System.out.println("Sailboat Constructor called");
    }

    /** Creates a named sailboat. */
    public Sailboat(String name) {
        super(name);
        System.out.println("Sailboat Constructor with name called");
    }

    /** Moves the sailboat on water. */
    @Override
    public void move() {
        System.out.println("Whoosh! Sailing with the wind");
    }

    /** Returns the concrete vehicle type. */
    @Override
    public String getVehicleType() {
        return "Sailboat";
    }
}