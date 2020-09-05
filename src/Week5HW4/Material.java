package Week5HW4;

public class Material {
    private String name;
    private Fragility fragility;

    public Material(String name, Fragility fragility) {
        this.name = name;
        this.fragility = fragility;
    }

    public Fragility getFragility() {
        return fragility;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Material consist of: "
                + this.getName()
                + " which is : "
                + this.getFragility();
    }
}
