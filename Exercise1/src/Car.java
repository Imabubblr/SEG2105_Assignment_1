/** Represents a car, which is a land vehicle. */
public class Car extends LandVehicle {
    /** Creates an unnamed car. */
    public Car() {
        super();
        System.out.println("Car Constructor called");
    }

    /** Creates a named car. */
    public Car(String name) {
        super(name);
        System.out.println("Car Constructor with name called");
    }

    /** Moves the car on the road. */
    @Override
    public void move() {
        System.out.println("Vroom! Driving on the road");
    }

    /** Returns the concrete vehicle type. */
    @Override
    public String getVehicleType() {
        return "Car";
    }
}