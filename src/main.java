package src;

public class main {
    public static void main(String[] args){
        Controller parkingLot = Controller.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
