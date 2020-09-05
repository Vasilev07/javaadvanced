package Week5HW4;

import java.util.ArrayList;
import java.util.List;

public class Item extends Shipment {
    private List<Element> elements = new ArrayList<Element>();
    private Box box;

    public void addElement(Element element) {
        elements.add(element);
    }

    public double totalWeight() {
        double itemWeight = elements.stream().mapToDouble(Element::getQuantity).sum();

        return itemWeight;
    }

    public double shipmentPrice() {
        double totalWeight = totalWeight();

        if (totalWeight < 10) {
            priceForKilo = 5;
        } else if (totalWeight > 10 && totalWeight < 15) {
            priceForKilo = 10;
        } else {
            priceForKilo = 15;
        }

        return priceForKilo;
    }

    public boolean isItemFragile() {
        for (Element el : elements) {
            if (el.isFragile()) {
                return true;
            }
        }
        return false;
    }
}
