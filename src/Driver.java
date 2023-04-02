import java.util.ArrayList;

public class Driver extends Person{
    private ArrayList<Integer> ratingList;

    public Driver(String name, double accountBalance) {
        super(name, accountBalance);
        ratingList = new ArrayList<>();
    }

    public ArrayList<Integer> getRatingList() {
        return ratingList;
    }

    public void addRating(int rating) {
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
        System.out.println("Driver Info:");
        super.printInfo();
        System.out.print("Average Rating: " );
        if (ratingList.size() == 0) {
            System.out.println("N/A");
        } else {
            System.out.println(averageRating());
        }
    }


}
