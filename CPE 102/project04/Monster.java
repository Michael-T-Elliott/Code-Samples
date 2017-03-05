/**
 * Monster.java
 * Monster Class contains instructions for Monster RandomOccupant in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */

public class Monster extends RandomOccupant
{
	public Monster(Maze maze)
	{
		super(maze);
	}
	
	public Monster(Maze maze, long seed)
	{
		super(maze, seed);
	}
	
	public Monster(Maze maze, Square location)
	{
		super(maze, location);
	}


}
