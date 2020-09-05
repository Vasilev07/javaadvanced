package Week5HW4;

public class Shoes extends Shipment {
    private final Item item;
    private boolean canTryBeforeBuy;

    public Shoes(Item item, boolean canTryBeforeBuy){
        this.canTryBeforeBuy = canTryBeforeBuy;
        this.item = item;
    }

    public double shipmentPrice() {
        if (canTryBeforeBuy) {
            return item.shipmentPrice() * item.totalWeight() * 3 / 100;
        } else {
            return item.shipmentPrice() * item.totalWeight();
        }
    }

    @Override
    public String toString() {
        return "Shoes cost: " + shipmentPrice() + "and weight" + item.totalWeight();
    }
}
