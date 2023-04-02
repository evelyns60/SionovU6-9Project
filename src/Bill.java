import java.text.DecimalFormat;

public class Bill {

    private Passenger passenger;
    private Car car;
    private double distance;
    private final double TAX = 8.75;
    private int tip;
    private DecimalFormat dollarFormat;


    public Bill(double distance, int tip, Passenger passenger, Car car) {
        this.distance = distance;
        this.tip = tip;
        this.passenger = passenger;
        this.car = car;
        dollarFormat = new DecimalFormat("#,##0.00");
    }

    public double getDistance() {
        return distance;
    }

    public double getTip() {
        return tip;
    }

    public double calculateTotalBeforeTipAndTax() {
        double total = 0;
        if (car.getCapacity() == 7) {
            total += distance * 2.00;
        } else {
            total += distance * 1.40;
        }
        return total;
    }

    public double calculateTotalPrice(double totalBefore) {
        totalBefore += (TAX/100) * totalBefore;
        totalBefore += totalBefore * ((double)tip/100);
        return totalBefore;
    }

    public String toString() {
        String str = UberSimulation.getCyan() + "Your Bill:\n";
        str += "\nPassenger Name: " + passenger.getName();
        str += "\nDriver Name: " + car.getDriver().getName();
        str += "\nTotal Distance Ridden: " + distance + " miles";
        str += "\nCar Size: ";
        if (car.getCapacity() == 10) {
            str+= "Large, $2.00 per mile.";
        } else {
            str += "Small, $1.40 per mile.";
        }
        str += "\nTotal before Tax/Tip: $" + dollarFormat.format(calculateTotalBeforeTipAndTax());
        str += "\nTax: " + TAX + "%";
        str += "\nTip: " + tip + "%";

        double total = calculateTotalPrice(calculateTotalBeforeTipAndTax());
        str += "\nTOTAL: $" + UberSimulation.getRed() + dollarFormat.format(total) + UberSimulation.getCyan();
        passenger.removeBalance(total);
        car.getDriver().addBalance(total);

        str += "\n\nYour Current Balance: " + dollarFormat.format(passenger.getAccountBalance());
        str += "\nDriver(" + car.getDriver().getName() + ") Balance: " + dollarFormat.format(car.getDriver().getAccountBalance());
        return str;
    }
}