public class Car {
    private String licensePlate;
    private String carType;
    private int capacity;
    private Driver driver;

    public Car(String licensePlate, String carType, boolean isLargeVehicle, Driver driver) {
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.driver = driver;
        if (isLargeVehicle) {
            capacity = 10;
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

    public Driver getDriver() {
        return driver;
    }

    public String toString() {
        String str = "Car: " + getCarType();
        str += "\nCar Size: ";
        if (capacity > 4) {
            str+= "Large";
        } else {
            str += "Small";
        }
        str += "\nLicense Plate: " + getLicensePlate();
        return str;
    }
}