public class Player
{
	//instance variables
	private String name;
	private int sticksTaken;

	//constructors
	public Player(String name)
	{
    	this.name = name;
	}

	//methods
	public String toString()
	{
		return name;
	}

	public int sticksTaken()
	{
		return sticksTaken;
	}

	public void takeTurn(Pile p)
	{
		p.remove(1);
		sticksTaken = 1;
	}
}