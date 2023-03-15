public class Bill {

    private Passenger passenger;
    private Driver driver;
    private double distance;
    private boolean isLarge;
    private final double RIDE_FEE = 1.00;
    private final double TAX = 0.0875;
    private double tip;

    public Bill(double distance, Car car, double tip, Passenger passenger, Driver driver) {
        this.distance = distance;
        this.tip = tip;
        this.passenger = passenger;
        this.driver = driver;
        if (car.getCapacity() == 6) {
            isLarge = true;
        } else {
            isLarge = false;
        }
    }

    public double getDistance() {
        return distance;
    }

    public double getTip() {
        return tip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public double calculateTotalPrice() {
        double total = 0;
        if (isLarge) {
            total += distance * 2.00;
        } else {
            total += distance * 1.40;
        }

        total *= TAX;
        total += total * tip;
        total += RIDE_FEE;
        return total;
    }

    public void printInfo() {
        System.out.println("Name: " + passenger.getName());
        System.out.println();
    }

}
