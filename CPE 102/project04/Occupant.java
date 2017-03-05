/**
 * Occupant.java
 * Occupant Class contains instructions for Occupant parent class in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */
public abstract class Occupant implements DelimitedTextIO
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
	
	public String toText(char delimiter){
		return ((getClass().getName()) + delimiter + loc.row() + delimiter + loc.col()); 
	}

}