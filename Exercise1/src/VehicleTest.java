import java.util.ArrayList;
import java.util.List;

/** Demonstrates inheritance, polymorphism, constructor chaining, and counters. */
public class VehicleTest {
    /*
     * Vehicle is abstract, so it cannot be instantiated directly. A List<Vehicle>
     * can still store every concrete subclass because each one is a Vehicle.
     */
    public static void main(String[] args) {
        List<LandVehicle> landVehicles = new ArrayList<>();
        landVehicles.add(new LandVehicle());
        landVehicles.add(new LandVehicle());
        landVehicles.add(new LandVehicle("Tractor"));
        landVehicles.add(new LandVehicle("Bus"));

        List<WaterVehicle> waterVehicles = new ArrayList<>();
        waterVehicles.add(new WaterVehicle());
        waterVehicles.add(new WaterVehicle());
        waterVehicles.add(new WaterVehicle("Ferry"));
        waterVehicles.add(new WaterVehicle("Canoe"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car("Civic"));
        cars.add(new Car("Corolla"));

        List<Sailboat> sailboats = new ArrayList<>();
        sailboats.add(new Sailboat());
        sailboats.add(new Sailboat());
        sailboats.add(new Sailboat("Bluenose"));
        sailboats.add(new Sailboat("Laser"));

        System.out.println("Land vehicles moving:");
        moveAll(landVehicles);
        System.out.println("Water vehicles moving:");
        moveAll(waterVehicles);
        System.out.println("Cars moving:");
        moveAll(cars);
        System.out.println("Sailboats moving:");
        moveAll(sailboats);

        System.out.println("Fleet:");
        List<Vehicle> fleet = new ArrayList<>();
        fleet.addAll(landVehicles);
        fleet.addAll(waterVehicles);
        fleet.addAll(cars);
        fleet.addAll(sailboats);
        for (Vehicle vehicle : fleet) {
            vehicle.describe();
        }

        System.out.println("Total number of vehicles: " + Vehicle.getNumberOfVehicles());
        System.out.println("Total number of land vehicles: " + LandVehicle.getNumberOfLandVehicles());
        System.out.println("Total number of water vehicles: " + WaterVehicle.getNumberOfWaterVehicles());
    }

    private static void moveAll(List<? extends Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}