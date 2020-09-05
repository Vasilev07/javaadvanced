package Week5HW4;

import java.util.ArrayList;
import java.util.List;

public class CourierCompany {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double totalEarnings() {
        double profit = 0;
        return items.forEach(el -> {
            profit += el.shipmentPrice();
        });

        return profit;
    }
}
