class Circle {
	private Point centre;
	private double radius;
	
	protected Circle(Point centre, double radius){
		this.centre = centre;
		this.radius = radius;
	}
	
	static Circle createCircle(Point centre, double radius){
		if(radius > 0){
			return new Circle(centre, radius);
		}else{
			return null;
		}
	}

	boolean contains(Point p){
		return this.centre.distanceto(p) < radius;
	}

	@Override	
	public String toString(){
		return this.centre + " and " + this.radius;
	}
}

