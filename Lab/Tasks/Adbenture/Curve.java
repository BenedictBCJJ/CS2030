public class Curve {
    private final double a;
    private final double b;
    private final double c;

    Curve(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getYGivenX(double x) {
        return this.a * x * x + this.b * x + c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public boolean containsPoint(Point point) {
        return point.getY() == this.getYGivenX(point.getX());
    }
    
    public boolean equals (Object obj) {
        if(obj instanceof Curve){
            Curve curve = (Curve) obj;
            return (this.a / curve.getA()) == (this.b / curve.getB()) 
                && this.b / curve.getB() == this.c / curve.getC();
        } else {
            return false;
        }
    }

}
