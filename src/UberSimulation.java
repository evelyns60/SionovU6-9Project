import java.util.Scanner;

public class UberSimulation {
    private Passenger passenger;
    private Car currentCar;
    private Bill currentBill;
    private Car[][] cars;
    private boolean isBroke;
    private Scanner scan;
    private final static String RED = "\u001B[31m";
    private final static String CYAN = "\033[0;34m";
    private final static String BROWN = "\u001B[33m";
    private final static String PURPLE = "\033[0;35m";
    private final static String WHITE = "\u001B[37m";

    public UberSimulation() {
        initializeCarList();
        currentCar = null;
        currentBill = null;
        scan = new Scanner(System.in);
        isBroke = false;
    }

    public static String getRed() {
        return RED;
    }

    public static String getWhite() {
        return WHITE;
    }

    public static String getPurple() {
        return PURPLE;
    }

    public static String getCyan() {
        return CYAN;
    }

    public void play() {
        printIntroduction();
        printMenu();
        System.out.print("Choose an option: ");
        int option = scan.nextInt();
        scan.nextLine();
        isBroke = passenger.getAccountBalance() <= 0;

        while (option != 4 && !isBroke) {
            if (option == 1) {
                orderRide();
            } else if (option == 2) {
                passenger.printInfo();
            } else {
                printAppStats();
            }
            if (passenger.getAccountBalance() <= 0) {
                isBroke = true;
            }
            printMenu();
            System.out.print("Choose an option: ");
            option = scan.nextInt();
            scan.nextLine();
        }

        if (isBroke) {
            System.out.println("Your account balance is insufficient.");
            if (passenger.getAccountBalance() < 0) {
                System.out.println("You're now officially in debt, and owe us quite a lot. Come again when you've paid your dues.");
            } else {
                System.out.println("Come again when you're not broke.");
            }
        } else {
            System.out.println("Thank you for riding with us!");
            System.out.println("Have an uber-licious day!");
        }
    }

    private void printIntroduction() {
        System.out.println("Welcome to the Official Uber App!");
        System.out.print("Before we get started, we'd like for you to give us your full name: ");
        String name = scan.nextLine();

        System.out.print("Great, we'd also like to know your current account balance: ");
        double accountBalance = scan.nextDouble();
        scan.nextLine();

        passenger = new Passenger(name, accountBalance);
        System.out.println("Welcome aboard, " + passenger.getName() + "!");
    }

    private void printMenu() {
        System.out.println(BROWN + "* - * - * - * - * - * - * - * - * - * - * - *");
        System.out.println("Main Menu: \n");
        System.out.println("1. Order a Ride");
        System.out.println("2. Check Your Uber Account Info");
        System.out.println("3. Check the Uber App Stats");
        System.out.println("4. Quit");
        System.out.println("* - * - * - * - * - * - * - * - * - * - * - *" + WHITE);
    }

    private void printAppStats() {
        System.out.println("\nUber App Stats: \n");
        System.out.println("Our Cars: ");
        for (Car[] arr: cars) {
            for (Car car: arr) {
                System.out.println(car);
                car.getDriver().printInfo();
                System.out.println();
            }
        }
    }

    private void orderRide() {
        System.out.print("How many " + PURPLE + "miles" + WHITE + " is it to your location? ");
        double distance = scan.nextDouble();
        scan.nextLine();

        currentCar = setCurrentCar(currentCar);


        System.out.println("Loading..");
        System.out.println("...");
        System.out.println("......");
        System.out.println(".........");
        System.out.println("COMPLETE!");
        System.out.println("\nYour Car Has Arrived! \n\nDetails: ");
        System.out.println(PURPLE + currentCar + WHITE);
        System.out.println();
        currentCar.getDriver().printInfo();
        System.out.print("\nEnter any key when your ride is complete. " );
        String next = scan.nextLine();
        System.out.print("What " + PURPLE + "percentage tip " + WHITE + "will you be giving to your driver? ");
        int tipPercentage = scan.nextInt();
        scan.nextLine();

        currentBill = new Bill(distance, tipPercentage, passenger, currentCar);
        System.out.println();
        System.out.println(currentBill);

        System.out.print("Wait! Before you go, how would you rate your driver on a scale of " + RED + "1-5" + WHITE + "? ");
        int rating = scan.nextInt();
        scan.nextLine();
        currentCar.getDriver().addRating(rating);
        passenger.addRide();
        currentCar.getDriver().addRide();
    }

    private void initializeCarList() {
        Driver driver1 = new Driver("Lukas Cane", 250.58);
        Driver driver2 = new Driver("Chris Griffin", 675.55);
        Driver driver3 = new Driver("Gavin Smith", 532.81);
        Driver driver4 = new Driver("Enzo Kravitz", 988.15);

        cars = new Car[][]{
                {new Car("6HQB442", "Toyota Camry", false, driver1), new Car("CDB8964", "Nissan Altima", false, driver2), new Car("GKM235", "Honda Accord", false, driver3), new Car("4YUX686", "Lincoln Towncar", false, driver4)},
                {new Car("5CPF367", "Toyota Highlander", true, driver1), new Car("VST9095", "Nissan Pathfinder", true, driver2), new Car("HCZ1186","Dodge Caravan", true, driver3), new Car("5KEN014","Toyota Sienna", true, driver4)}
        };
    }

    private Car setCurrentCar(Car car) {
        System.out.print("How many " + PURPLE + "people" + WHITE+ " will be in this car(including you)? ");
        int capacity = scan.nextInt();
        scan.nextLine();
        while (capacity > 10) {
            System.out.println(RED + "Uber does not support vehicles with a capacity greater than 10. Please try again." + WHITE);
            System.out.print("How many " + PURPLE + "people" + WHITE + " will be in this car(including you)? ");
            capacity = scan.nextInt();
            scan.nextLine();
        }
        int randomNum = (int) (Math.random() * cars[0].length);
        if (capacity <= 4) {
            car = cars[0][randomNum];
        } else {
            car = cars[1][randomNum];
        }
        return car;
    }

}
