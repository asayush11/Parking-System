package src;

import java.util.ArrayList;
import java.util.List;
public class Level {
    private final int floor;
    private final List<Spot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        // Assign spots in ratio of 50:50 for bikes, cars
        double spotsForBikes = 0.50;
        double spotsForCars = 0.50;

        int numBikes = (int) (numSpots * spotsForBikes);
        int numCars = (int) (numSpots * spotsForCars);

        for (int i = 1; i <= numBikes; i++) {
            parkingSpots.add(new Spot(i,VehicleType.MOTORCYCLE));
        }
        for (int i = numBikes + 1; i <= numBikes + numCars; i++) {
            parkingSpots.add(new Spot(i,VehicleType.CAR));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (Spot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (Spot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        parkingSpots
                .forEach(spot -> System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType()));
    }
}
