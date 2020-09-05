package Week5HW4;

public class Box {
    public BoxSize size;

    private double height;
    private double width;
    private double length;


    public Box(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public BoxSize volume() {
        double size = this.getSize();

        if (size > 10 && size < 15) {
            this.size = BoxSize.M;
        } else if (size > 15 && size < 20) {
            this.size = BoxSize.L;
        } else {
            this.size = BoxSize.XL;
        }

        return this.size;
    }

    private double getSize() {
        return height * width * length;
    }
}
