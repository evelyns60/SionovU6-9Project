import java.util.Scanner;

public class UberSimulation {
    private Passenger passenger;
    private Driver driver;
    private Car car;
    private final String[][] carTypes = {{"Toyota Camry", "Nissan Altima", "Honda Accord", "Lincoln Towncar"},{"Toyota Highlander", "Nissan Pathfinder", "Dodge Caravan", "Toyota Sienna"}};
    private Scanner scan;

    public UberSimulation() {
         scan = new Scanner(System.in);
    }

    public void play() {
        printIntroduction();
        printMenu();
        System.out.print("Choose an option: ");
        int option = scan.nextInt();
        scan.nextLine();

        while (option != 4) {
            if (option == 1) {

            } else if (option == 2) {
                passenger.printInfo();
            } else {

            }
            printMenu();
            System.out.print("Choose an option: ");
            option = scan.nextInt();
            scan.nextLine();
        }

    }

    private void printIntroduction() {
        System.out.println("Welcome to the Official Uber App!");
        System.out.print("Before we get started, we'd like for you to give us your full name: ");
        String name = scan.nextLine();

        System.out.print("Great, we'd also like to know your current account balance: ");
        int accountBalance = scan.nextInt();
        scan.nextLine();

        passenger = new Passenger(name, accountBalance);
        System.out.println("Welcome aboard, " + passenger.getName() + "!");
    }

    private void printMenu() {
        System.out.println("Main Menu: \n");
        System.out.println("1. Order a Ride");
        System.out.println("2. Check Your Uber Account Info");
        System.out.println("3. Check Your Purchase History");
        System.out.println("4. Quit");
    }

}
