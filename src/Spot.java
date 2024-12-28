package src;

import java.sql.Timestamp;

public class Spot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;
    private Timestamp parkTime;

    public Spot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType() == vehicleType) {
            parkedVehicle = vehicle;
            parkTime = new Timestamp((System.currentTimeMillis()));
        } else {
            throw new IllegalArgumentException("Cannot Park.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
        long parkDuration = (new Timestamp((System.currentTimeMillis()))).getTime() - parkTime.getTime();
        // it should be hours in real world
        double durationInMilliSeconds = parkDuration / 1000.0;
        double cost = (durationInMilliSeconds * 10.0);
        System.out.println("Amount to be paid: " + cost);
        parkTime = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
