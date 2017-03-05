
public class Person extends Animal
{
	private String name;

	public Person(String name, int nLegs)
	{
		super(nLegs);
		this.name = name;
	}
	public String toString()
	{
		return (super.toString() + " and a person object whose name is " + name);
	}

	public boolean equals(Object other)
	{
		if (super.equals(other) && ((Person)other).name == this.name)
			return true;

		return false;
	}

}