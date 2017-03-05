/**
 * Occupant.java
 * Occupant Class contains instructions for Occupant parent class in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */
public class Occupant
{
	private Square loc;
	
	public Occupant() { }
	
	public Occupant(Square start)
	{
		loc = start;
	}
	
	public Square location()
	{
		return loc;
	}
	
	public void moveTo(Square newLoc)
	{
		loc = newLoc;
	}
	
}