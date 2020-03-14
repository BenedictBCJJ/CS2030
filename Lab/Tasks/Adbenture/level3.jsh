/open Point.java
/open Curve.java
/open Line.java
Curve c1 = new Curve(0, 2, 3);
Line l1 = new Line(2, 3);
Line l2 = new Line(4, 6);
Line l3 = new Line(1, 1);
Point p1 = new Point(2, 3);
l1.equals(l2);
l1.equals(l3);
l1.equals(c1);
l1.containsPoint(p1);
l3.containsPoint(p1);
l1.getDiscriminant();
/exit