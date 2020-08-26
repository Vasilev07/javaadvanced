package Week4HW3;

public class Manufacturer {
    private String name;
    private int minWarranty = 12;

    public Manufacturer(String name) {
        this.name = name;
    }

    public int shouldProvideExtendWarranty() {
        return 12;
    }

    public int getMinWarranty() {
        return minWarranty;
    }

    public String getName() {
        return name;
    }
}
