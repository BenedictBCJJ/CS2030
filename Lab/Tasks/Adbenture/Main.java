import java.util.Scanner;
class Main{
    public static void main(String[] vargs) {
        Scanner sc = new Scanner(System.in);
        Point point = new Point(sc.nextDouble(), sc.nextDouble());
        Line line = new Line(sc.nextDouble(), sc.nextDouble());
        Curve curve = new Curve(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.println("Does the point lie on the line?");
        System.out.println("Answer: " + line.containsPoint(point));
        System.out.println("Does the point lie on the curve?");
        System.out.println("Answer: " + curve.containsPoint(point));
    }
}



