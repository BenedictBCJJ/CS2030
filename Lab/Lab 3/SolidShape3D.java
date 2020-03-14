class SolidShape3D implements Solid {
    private final ThreeDShape shape;
    private final Material material;

    SolidShape3D(ThreeDShape shape, Material material) {
        this.shape = shape;
        this. material = material;
    }

    @Override
    public double getDensity() {
        return this.material.getDensity();
    }

    @Override
    public double getMass() {
        return this.getDensity() * this.shape.getVolume();
    }

    @Override
    public String toString() {
        return String.format("Solid%s with a mass of %.2f", this.shape.toString(), this.getMass());
    }
}
