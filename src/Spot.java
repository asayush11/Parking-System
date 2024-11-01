package src;

//import Vehicle;
//import parkinglot.vehicletype.VehicleType;
public class Spot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

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
        } else {
            throw new IllegalArgumentException("Cannot Park.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
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
