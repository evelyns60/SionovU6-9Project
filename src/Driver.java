import java.util.ArrayList;

public class Driver extends Person{

    private ArrayList<Double> ratingList;

    public Driver(String name, double accountBalance) {
        super(name, accountBalance);
        ratingList = new ArrayList<>();
    }

    public void addRating(double rating) {
        ratingList.add(rating);
    }

    public double averageRating() {
        double total = 0;
        for (double rating: ratingList) {
            total += rating;
        }
        return total/ratingList.size();
    }

    @Override
    public void printInfo() {
        System.out.println("Driver Info: \n");
        super.printInfo();
        System.out.println("Average Rating: " + averageRating());
    }


}
