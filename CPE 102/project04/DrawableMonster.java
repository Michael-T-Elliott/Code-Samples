/**
 * DrawableMonster.java
 * DrawableMonster Class contains instructions to draw Monster
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */
public class DrawableMonster extends Monster implements Drawable
{
  
	public DrawableMonster(Maze maze)
	{
		super(maze);
	}
	
	public DrawableMonster(Maze maze, long seed)
	{
		super(maze, seed);
	}
	
	public DrawableMonster(Maze maze, Square location)
	{
		super(maze, location);
	}

    public void draw()
    {

    }

}
