class Cuboid extends ThreeDShape implements ScaleCube {
    private final double height;
    private final double width;
    private final double length;

    public Cuboid(double height, double width, double length) {
        this.height = height;
        this.length = length;
        this. width = width;
    }


    @Override
    public String toString() {
        return String.format("Cuboid [%.2f x %.2f x %.2f]", this.height, this.width, this.length);
    }

    @Override
    public double getSurfaceArea() {
        return (this.height * this.width * 2) + (this.width * this.length * 2) 
            + (this.length * this.height * 2);
    }

    @Override
    public double getVolume() {
        return this.height * this.length * this.width;
    }

    @Override
    public Cuboid setHeight(double height) {
        return new Cuboid(height, this.width, this.length);
    }

    @Override
    public Cuboid setWidth(double width) {
        return new Cuboid(this.height, width, this.length);
    }
    
    @Override
    public Cuboid setLength(double length) {
        return new Cuboid(this.height, this.width, length);
    }
}
