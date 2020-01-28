class Point{
	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	Point setx(double x){
		return new Point(x, this.y);
	}

	Point sety(double y){
		return new Point(this.x, y);
	}
	
	Point moveby(double x, double y){
		return new Point(this.x + x, this.y + y);
	
	}
	
	public double distanceto(Point otherPoint){
		double dx = this.x - otherPoint.x;
		double dy = this.y - otherPoint.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	public boolean equals(Object obj){
		if(obj == this){
			return true;
		}else{
			if(obj instanceof Point){
				Point p = (Point) obj;

				return this.x == p.x && this.y == p.y;

			}else{
				return false;
			}
		}
	}

	@Override
	public String toString(){
		return "(" + this.x + ", " + this.y + ")";
	}
}

