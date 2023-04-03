import java.text.DecimalFormat;

public class Person {
    private String name;
    private double accountBalance;
    private int numRides;
    private DecimalFormat dollarFormat;

    public Person(String name, double accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        numRides = 0;
        dollarFormat = new DecimalFormat("#,##0.00");
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getNumRides() {
        return numRides;
    }

    public void addRide() {
        numRides++;
    }

    public void addBalance(double money) {
        accountBalance += money;
    }

    public void removeBalance(double money) {
        accountBalance -= money;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Current Account Balance: $" + dollarFormat.format(accountBalance));
        System.out.println("Total Uber Rides: " + numRides);
    }
}