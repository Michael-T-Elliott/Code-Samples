/**
 * DrawableTreasure.java
 * DrawableTreasure Class contains instructions to draw Treasure
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */
public class DrawableTreasure extends Treasure implements Drawable
{
	public DrawableTreasure(Maze maze)
	{
		super(maze);
	}
	
	public DrawableTreasure(Maze maze, long seed)
	{
		super(maze, seed);
	}
	
	public DrawableTreasure(Maze maze, Square location)
	{
		super(maze, location);
	}
	
	public void draw()
	{         
  
	}
}
