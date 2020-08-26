package Week4HW3;

public class Customer {
    private String name;
    private int budget;

    public String buy(Laundry laundry) {
        int elToolPrice = laundry.getPrice();

        if (elToolPrice <= budget) {
            return "We have bought" + laundry.toString();
        } else {
            return "Not enough money";
        }
    }

    public String buy(Cooker cooker) {
        int elToolPrice = cooker.getPrice();

        if (elToolPrice <= budget) {
            return "We have bought" + cooker.toString();
        } else {
            return "Not enough money";
        }
    }
}
