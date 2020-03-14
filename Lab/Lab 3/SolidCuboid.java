class SolidCuboid extends ThreeDShape implements ScaleCube, Solid {
    private final double height;
    private final double width;
    private final double length;
    private final double density;

    public SolidCuboid(double height, double width, double length, double density) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.density = density;
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
    public SolidCuboid setHeight(double height) {
        return new SolidCuboid(height, this.width, this.length, this.density);
    }

    @Override
    public SolidCuboid setWidth(double width) {
        return new SolidCuboid(this.height, width, this.length, this.density);
    }
    
    @Override
    public SolidCuboid setLength(double length) {
        return new SolidCuboid(this.height, this.width, length, this.density);
    }

    @Override
    public double getDensity() {
        return this.density;
    }

    @Override
    public double getMass() {
        return this.getVolume() * this.getDensity();
    }

    @Override
    public String toString() {
        return String.format("SolidCuboid [%.2f x %.2f x %.2f] with a mass of %.2f", 
                this.height, this.width, this.length, this.getMass());
    }

}



