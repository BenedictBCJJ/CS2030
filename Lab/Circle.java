class Circle{
	Point centre;
	double radius;

	private Circle(Point centre, double radius){
		this.centre = centre;
		this.radius = radius;
	}

	public static Circle getCircle(Point centre, double radius){
		if(radius > 0) {
			return new Circle(centre, radius);
		}else{
			return null;
		}
	}
	
	boolean contains(Point p){
		return this.centre.distanceTo(p) <= radius;
	}
	
	@Override
	public String toString(){
		return "circle of radius " + this.radius + " centered at " + this.centre;
	}
}
