package Week5HW4;

public class Element {
    private Material material;
    private double quantity;

    public Element(Material material, double quantity) {
        this.quantity = quantity;
        this.material = material;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isFragile() {
        return material.getFragility() == Fragility.FRAGILE;
    }

    @Override
    public String toString() {
        return "Element consist of: "
                + this.material.getName()
                + " which is : "
                + this.material.getFragility()
                + "and made of" + this.material
                + "and is:"
                + this.quantity;
    }
}
