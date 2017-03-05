/**
 * Treasure.java
 * Treasure Class contains instructions for Treasure RandomOccupant in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */
public class Treasure extends RandomOccupant
{
	private boolean found;
	
	public Treasure(Maze maze)
	{
		super(maze);
		this.found = false;
		Square loc = this.location();
		loc.setTreasure(this);
	}
	
	public Treasure(Maze maze, long seed)
	{
		super(maze, seed);
		this.found = false;
		Square loc = this.location();
	}
	
	public Treasure(Maze maze, Square location)
	{
		super(maze, location);
		this.found = false;
		Square loc = this.location();
		loc.setTreasure(this);
	}
	
	public boolean found()
	{
		return found;
	}
	
	public void setFound()
	{
		found = true;
	}
	
	public void move() {}
}