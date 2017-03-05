/**
 * RandomOccupant.java
 * RandomOccupant Class contains instructions for RandomOccupant class in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */

import java.util.Random;

public class RandomOccupant extends Occupant
{
	private Random randObject;
	private Maze maze;
	
	public RandomOccupant(Maze maze)
	{
		super();
		this.randObject = new Random();
		this.maze = maze;
		super.moveTo(maze.getSquare(randObject.nextInt(maze.rows()),randObject.nextInt(maze.cols())));
		
	}
	
	public RandomOccupant(Maze maze, long seed)
	{
		super();
		this.maze = maze;
		this.randObject = new Random(seed);
		this.moveTo(maze.getSquare(randObject.nextInt(maze.rows()),randObject.nextInt(maze.cols())));
	}
	
	public RandomOccupant(Maze maze, Square location)
	{
		super(location);
		this.maze = maze;
		this.randObject = new Random();
		//Square newLoc = maze.getSquare(location.row(),location.col());
		//this.moveTo(newLoc);
	}
	
	public void move()
	{
		Square loc = this.location();
		int row = loc.row();
		int col = loc.col();
		int direction = this.randObject.nextInt(4);
		
		while (loc.wall(direction) == true)
		{
			direction = this.randObject.nextInt(4);
		}
		
		if (direction == Square.DOWN && loc.wall(Square.DOWN) != true)
		{
			row += 1;
			Square newLoc = maze.getSquare(row, col);
			moveTo(newLoc);
		}
		if (direction == Square.UP && loc.wall(Square.UP) != true)
		{
			row -= 1;
			Square newLoc = maze.getSquare(row, col);
			moveTo(newLoc);
		}
		if (direction == Square.LEFT && loc.wall(Square.LEFT) != true)
		{
			col -=1;
			Square newLoc = maze.getSquare(row, col);
			moveTo(newLoc);
		}
		if (direction == Square.RIGHT && loc.wall(Square.RIGHT) != true)
		{
			col += 1;
			Square newLoc = maze.getSquare(row, col);
			moveTo(newLoc);
		}
	}
	
}