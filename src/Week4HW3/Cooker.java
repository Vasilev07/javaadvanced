package Week4HW3;

public class Cooker {
    private Manufacturer manufacturer;
    private CookerType type;
    private int warranty;
    private int price;

    public Cooker(Manufacturer manufacturer, CookerType type, int price) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int setWarranty(CookerType type) {
        int minWarrantyByManufacturer = this.manufacturer.getMinWarranty();
        int extendedWarranty = this.manufacturer.shouldProvideExtendWarranty();

        if (type == CookerType.GAS) {
            this.warranty = minWarrantyByManufacturer + extendedWarranty + 12;
        } else {
            this.warranty = minWarrantyByManufacturer + extendedWarranty;
        }

        return this.warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
            return "Cooker: " + this.manufacturer.getName() + "...type: " + this.type;
    }
}
