public class Bill {

    private Passenger passenger;
    private Driver driver;
    private double distance;
    private final double RIDE_FEE = 1.00;
    private final double TAX = 0.0875;
    private double tip;

    public Bill(double distance, double tip, Passenger passenger, Driver driver) {
        this.distance = distance;
        this.tip = tip;
        this.passenger = passenger;
        this.driver = driver;
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

    public double calculateTotalPrice(Car car) {
        double total = 0;
        if (car.getCapacity() == 6) {
            total += distance * 2.00;
        } else {
            total += distance * 1.40;
        }

        total *= TAX;
        total += total * tip;
        total += RIDE_FEE;
        return total;
    }

    public String toString() {
        String str = "Name: " + passenger.getName();
        str += "";
        return str;
    }

}
