class Sphere extends ThreeDShape {
    private final double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSurfaceArea() {
        return (this.radius * this.radius * 4 * Math.PI);
    }

    @Override
    public double getVolume() {
        return this.radius * this.radius * this.radius * 4 / 3 * Math.PI;
    }

    public Sphere setRadius(double radius) {
        return new Sphere(radius);
    }

    @Override
    public String toString() {
        return String.format("Sphere [%.2f]", this.radius);
    }
}




