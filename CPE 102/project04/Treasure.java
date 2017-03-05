/**
 * Treasure.java
 * Treasure Class contains instructions for Treasure RandomOccupant in maze game
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */

import java.util.Scanner;

public class Treasure extends RandomOccupant 
{
	private boolean found;
	
	public Treasure(Maze maze)
	{
		super(maze);
		this.found = false;
		Square loc = this.location();
	}
	
	public Treasure(Maze maze, long seed)
	{
		super(maze, seed);
		this.found = false;
		Square loc = this.location();
		loc.setTreasure(this);
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

	public void moveTo(Square newLoc)
	{
		if (this.location() != null){
			location().setTreasure(null);
		}
		super.moveTo(newLoc);
		newLoc.setTreasure(this);
	}
	
	public String toText(char delimiter){
		return (super.toText(delimiter) + delimiter + found()); 
	}
	
	public void toObject(Scanner input){
		super.toObject(input);
		found = input.nextBoolean();
	}
}