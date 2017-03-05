
public class Student extends Person
{
	private double GPA;

	public Student(String name, int nLegs, double GPA)
	{
		super(name, nLegs);
		this.GPA = GPA;
	}
	public String toString()
	{
		return (super.toString() + " and a student object with a " + GPA + " gpa");
	}

	public boolean equals(Object other)
	{
		if (super.equals(other) && ((Student)other).GPA == this.GPA)
			return true;

		return false;
	}

}