import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static Circle createCircle(Point p, Point q, double radius){
		Point midpt = q.midPoint(p);
		double angle = q.angleTo(p);
		double distance_mq = midpt.distanceTo(q);
		double distance_mc = Math.sqrt(radius * radius - distance_mq * distance_mq );
		double angle_mc = angle - (Math.PI/2);
		Point centre = midpt.moveTo(angle_mc, distance_mc);

		if(distance_mq > radius || p.equals(q)){
			return null;
		}else{
			return Circle.getCircle(centre, radius);
		}
		
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		// uncomment for lab #0
		// double x = scan.nextDouble();
		// double y = scan.nextDouble();
		// double dx = scan.nextDouble();
		// double dy = scan.nextDouble();
		// double radius = scan.nextDouble();
		// Circle result = Main.createCircle(new Point(x, y), new Point(dx, dy), radius);
		// if(result == null){
			// System.out.println("No valid circle can be created");
		// }else{
			// System.out.println("Created: " + result);
		// }
		
		int no_of_points = scan.nextInt();
		Point[] points = new Point [no_of_points];
		for(int i = 0; i < no_of_points; i++){
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			points[i] = new Point(x, y);
		}
		int MaxCoverage = DiscCoverage(no_of_points, points);
		
		System.out.println("Maximum Disc Coverage: " +MaxCoverage);
	}
	
	public static int DiscCoverage(int no_of_points, Point[] points){
		int coverage = 0;
		int counter = 0;
		Circle[] created_circles = new Circle [(no_of_points * (no_of_points + 1)) / 2];
		for (int i = 0; i < no_of_points; i++){
			for(int j = i + 1; j < no_of_points; j++){
				Circle current = createCircle(points[i], points[j], points[i].distanceTo(points[j]));
				created_circles[counter] = current;
				counter++;
			}
		}
		for (int i = counter - 1; i >= 0; i--){
			int current_coverage = 0;
			for (int j = 0; j < no_of_points; j++){
				if(created_circles[i].contains(points[j])){
					current_coverage++;
				}
			}
			if(current_coverage > coverage){
				coverage = current_coverage;
			}
		}
		
		return coverage;
	}


}	
