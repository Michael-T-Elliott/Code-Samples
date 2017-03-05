
public class NegativeRadiusExceptions extends CircleException
{
	private double radius;

	public NegativeRadiusExceptions(double radius)
	{
		super("negative radius");
		this.radius = radius;
	}

	public double radius()
	{
		return radius;
	}
}