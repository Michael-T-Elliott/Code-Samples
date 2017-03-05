
public class CircleTest
{
	public static void main(String [ ] args)
	{
		//Testing a Circle of Radius 2, 
		try
		{
		 Circle c0 = new Circle(2);
		 System.out.println(c0);
		}
		catch (ZeroRadiusExceptions e) 
		{
		 System.out.println(e.getMessage());
		}
		catch (NegativeRadiusExceptions e) 
		{
		 System.out.println(e.getMessage() + ": " + e.radius());
		}

		//Testing a Circle of Radius 0
		try
		{
		 Circle c1 = new Circle(0);
		 System.out.println(c1);
		}
		catch (ZeroRadiusExceptions e) 
		{
		 System.out.println(e.getMessage());
		}

		//Testing a Circle of radius -1 
		try
		{
		 Circle c2 = new Circle(-1);
		 System.out.println(c2);
		}
		catch (NegativeRadiusExceptions e) 
		{
		 System.out.println(e.getMessage() + ": " + e.radius());
		}

		//testing a Circle of radius -19
		try
		{
		 Circle c3 = new Circle(-19);
		 System.out.println(c3);
		}
		catch (NegativeRadiusExceptions e) 
		{
		 System.out.println(e.getMessage() + ": " + e.radius());
		}

	}
}