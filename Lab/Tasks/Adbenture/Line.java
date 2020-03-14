public class Line extends Curve{
    
    Line(double b, double c) {
        super(0, b, c);
    }

    @Override
    public boolean equals (Object obj) {
        if(obj instanceof Line) {
            Line curve = (Line) obj;
            return super.getB() / curve.getB() == super.getC() / curve.getC();
        } else {
            return false;
        }
    }

    @Override
    public double getDiscriminant() {
        return 0;
    }
    

}

