public class CartesianPoint implements Point
{
	// instance variables
	private double xCoord, yCoord;

	// constructors
	public CartesianPoint(double xCoord, double yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
 
	public double angle()
	{

		double angle = Math.atan(yCoord/xCoord);
		if (yCoord == 0 || xCoord == 0)
		{
			angle = 0.0;
		}
		if (angle < 0)
		{
			angle = Math.PI+angle;
		}
		if (xCoord > yCoord && xCoord < 0 && yCoord < 0)
		{
			angle = Math.PI+angle;
		}
		return angle;
	}

	public double distanceFrom(Point other)
	{
		double x = (other.xCoordinate() - xCoord);
		double y = (other.yCoordinate() - yCoord);
		double distance = Math.sqrt((x*x) + (y*y));
		return distance;
	}

	public double radius()
	{
		return Math.sqrt((xCoord*xCoord) + (yCoord*yCoord));
	}

	public Point rotate90()
	{
		CartesianPoint p = new CartesianPoint(xCoord, yCoord);

		double s = Math.round(Math.sin(p.angle()));
  		double c = Math.round(Math.cos(p.angle()));


  		double x = p.xCoord;
		double y = p.yCoord;

  		double newy = (x*c) + (y*s);
  		double newx = -(x*s) + (y*c);

  		if (newx < 0)
  		{
  			newx = -newx;
  		}
 
  		CartesianPoint RotatedPoint = new CartesianPoint(newx, newy);

		return RotatedPoint;
	}

	public double xCoordinate()
	{
		return xCoord;
	}

	public double yCoordinate()
	{
		return yCoord;
	}
}