/open Point.java
/open Curve.java
Curve c1 = new Curve(1, 2, 3);
Curve c2 = new Curve(4, 5, 6);
Curve c3 = new Curve(2, 4, 6);
Point p1 = new Point(1, 6);
c1.containsPoint(p1);
c1.equals(c2);
c1.equals(c3);
c1.equals(p1);
/exit