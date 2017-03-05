
public class Animal
{
	private int nLegs;

	public Animal(int nLegs)
	{
		this.nLegs = nLegs;
	}

	public String toString()
	{
		return ("I am an Animal object with " + nLegs + " legs");
	}

	public boolean equals(Object other)
	{
		if (other.getClass() == this.getClass() && other != null && ((Animal)other).nLegs == this.nLegs)
			return true;

		return false;
	}
}