public class Passenger extends Person{
    public Passenger(String name, double accountBalance) {
        super(name, accountBalance);
    }

    @Override
    public void printInfo() {
        System.out.println(UberSimulation.getPurple() + "Passenger Info: \n");
        super.printInfo();
        System.out.print(UberSimulation.getWhite());
    }
}
