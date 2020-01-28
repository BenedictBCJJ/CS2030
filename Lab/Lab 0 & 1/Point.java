class Point{
	private double x;
	private double y;

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	
	}
	@Override
	public boolean equals(Object obj){
		Point p = (Point) obj;
		return this.x == p.x && this.y == p.y;
	}

	@Override
	public String toString(){
		return String.format("point (%.3f, %.3f)", this.x, this.y);
	}

	public Point midPoint(Point otherpt){
		double midx = (otherpt.x + this.x) / 2;
	        double midy = (otherpt.y + this.y) / 2;
		return new Point (midx, midy);
	}

	public double angleTo(Point otherpt){
		double opp = otherpt.x - this.x;
		double adj = otherpt.y - this.y;
		return Math.atan2(adj, opp);
	}
	
	public double distanceTo(Point otherpt){
		double dx = this.x - otherpt.x;
		double dy = this.y - otherpt.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public Point moveTo(double angle, double distance){
		return new Point (this.x + distance * Math.cos(angle),
				  this.y + distance * Math.sin(angle));
	}	
}
