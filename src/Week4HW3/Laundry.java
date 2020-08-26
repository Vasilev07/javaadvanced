package Week4HW3;

public class Laundry {
    private Manufacturer manufacturer;
    private LaundryType type;
    private int warranty;
    private int price;

    public void Laundry(Manufacturer manufacturer, LaundryType type, int price) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int setWarranty(LaundryType type) {
        int minWarrantyByManufacturer = this.manufacturer.getMinWarranty();
        int extendedWarranty = this.manufacturer.shouldProvideExtendWarranty();

        if (type == LaundryType.DRIER) {
            this.warranty = minWarrantyByManufacturer + minWarrantyByManufacturer / 2 +  extendedWarranty;
        } else {
            this.warranty = minWarrantyByManufacturer + extendedWarranty;
        }

        return this.warranty;
    }

    public int getWarranty() { return warranty; };

    @Override
    public String toString() {
        return "Laundry: " + this.manufacturer.getName() + "...type: " + this.type;
    }
}
