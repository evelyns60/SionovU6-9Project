public class Car {
    private String licensePlate;
    private String carType;
    private int capacity;

    public Car(String licensePlate, String carType, boolean isLargeVehicleNeeded) {
        this.licensePlate = licensePlate;
        this.carType = carType;
        if (isLargeVehicleNeeded) {
            capacity = 7;
        } else {
            capacity = 4;
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCarType() {
        return carType;
    }

    public int getCapacity() {
        return capacity;
    }

}