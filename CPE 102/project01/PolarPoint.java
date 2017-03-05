public class PolarPoint implements Point
{
	// instance variables
	private double radius, angle;

	// constructors
	public PolarPoint(double radius, double angle)
	{
		this.radius = radius;
		this.angle = angle;
	}

	public double angle()
	{
		return angle;
	}

	public double distanceFrom(Point other)
	{
		double x = (other.xCoordinate() - this.xCoordinate());
		double y = (other.yCoordinate() - this.yCoordinate());
		double distance = (Math.sqrt((x*x) + (y*y)));
		return distance;
	}

	public double radius()
	{
		return radius;
	}

	public Point rotate90()
	{
		PolarPoint p = new PolarPoint(radius, angle);

		double x = p.radius;
		double y = p.angle;

		double newx = x;
		double newy = y + (Math.PI/2);

		PolarPoint rotated = new PolarPoint(newx, newy);
		return rotated;
	}

	public double xCoordinate()
	{
		double x = (radius * Math.cos(angle));
		return x;
	}

	public double yCoordinate()
	{
		double y = (radius * Math.sin(angle));
		return y;
	}
}