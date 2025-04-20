package src;

import java.util.ArrayList;
import java.util.List;
public class Controller {
    private static Controller instance;
    private final List<Level> levels;

    private Controller() {
        levels = new ArrayList<>();
    }

    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully.");
                return;
            }
        }
        System.out.println("Could not park vehicle.");
    }

    public void unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return;
            }
        }
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
