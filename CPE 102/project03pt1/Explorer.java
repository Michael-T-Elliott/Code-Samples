/**
 * Explorer.java
 * Explorer Class contains instructions for Explorer occupant in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */

import java.awt.event.KeyEvent;

public class Explorer extends Occupant
{
	private String name;
	private Maze maze;
	
	public Explorer(Square location, Maze maze, String name)
	{
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(location);
	}
	
	public String name()
	{
		return name;
	}
	
	public void move(int key)
	{
		Square loc = this.location();
		int row = loc.row();
		int col = loc.col();
		
		if ((key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN) && loc.wall(Square.DOWN) != true)
		{
			row += 1;
			moveTo(maze.getSquare(row, col));
		}
		if ((key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP) && loc.wall(Square.UP) != true)
		{
			row -= 1;
			moveTo(maze.getSquare(row, col));
		}
		if ((key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT) && loc.wall(Square.LEFT) != true)
		{
			col -=1;
			moveTo(maze.getSquare(row, col));
		}
		if ((key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT) && loc.wall(Square.RIGHT) != true)
		{
			col += 1;
			moveTo(maze.getSquare(row, col));
		}
	}
	
	public void moveTo(Square s)
	{
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
	}
	
}