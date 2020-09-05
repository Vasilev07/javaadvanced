package Week5HW4;

public class Furniture extends Shipment {
    private final Item item;
    private final String make;

    public Furniture(String make, Item item){
        this.make = make;
        this.item = item;
    }

    public double shipmentPrice() {
        if (item.isItemFragile() && item.totalWeight() > 20) {
            return item.shipmentPrice() * 1.5;
        } else {
            return item.shipmentPrice();
        }
    }
}
