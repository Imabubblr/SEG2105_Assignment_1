/**
 * Name: Henry Shi
 * Student ID: 300474640
 */

/**
 * Represents the common state and behavior of every vehicle in the program.
 */
public abstract class Vehicle implements Movable {
	private static int numberOfVehicles = 0;
	private String name;

	/** Creates an unnamed vehicle. */
	public Vehicle() {
		numberOfVehicles++;
		System.out.println("Vehicle Constructor called");
		name = "Unnamed Vehicle";
	}

	/** Creates a vehicle with a given name. */
	public Vehicle(String name) {
		numberOfVehicles++;
		System.out.println("Vehicle Constructor with name called");
		this.name = name;
	}

	/** Returns the type of the vehicle. */
	public abstract String getVehicleType();

	/** Moves this vehicle according to its concrete type. */
	public abstract void move();

	/** Returns this vehicle's name. */
	public String getName() {
		return name;
	}

	/** Prints a description of the vehicle. */
	public void describe() {
		System.out.println(name + " is a " + getVehicleType());
	}

	/** Returns the total number of vehicles created. */
	public static int getNumberOfVehicles() {
		return numberOfVehicles;
	}
}
