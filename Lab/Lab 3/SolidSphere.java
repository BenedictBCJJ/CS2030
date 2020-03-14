public class SolidSphere extends ThreeDShape implements Solid {
    private final double radius;
    private final double density;

    SolidSphere(double radius, double density) {
        this.radius = radius;
        this.density = density;
    }

    @Override
    public double getSurfaceArea() {
        return (this.radius * this.radius * 4 * Math.PI);
    }

    @Override
    public double getVolume() {
        return this.radius * this.radius * this.radius * 4 / 3 * Math.PI;
    }

    public SolidSphere setRadius(double radius) {
        return new SolidSphere(radius, this.density);
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
        return String.format("SolidSphere [%.2f] with a mass of %.2f", this.radius, this.getMass());
    }
}
