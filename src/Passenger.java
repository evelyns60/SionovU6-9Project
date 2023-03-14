public class Passenger extends Person{

    public Passenger(String name, double accountBalance) {
        super(name, accountBalance);
    }

    @Override
    public void printInfo() {
        System.out.println("Passenger Info: \n");
        super.printInfo();
    }



}
