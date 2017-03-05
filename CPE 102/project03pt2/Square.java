/**
 * Square.java
 * Square Class contains instructions for Square tile in Maze Game
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */
public class Square
{
	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;

	private boolean[] walls = new boolean[4];
	private boolean squareSeen;
	private boolean squareInView;
	private int row;
	private int col;
	private Treasure treasure;

	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
	{
		walls[0] = up;
		walls[1] = right;
		walls[2] = down;
		walls[3] = left;
		squareSeen = false;
		squareInView = false;
		treasure = null;
		this.row = row;
		this.col = col;
	}

	public boolean wall(int direction)
	{
		return walls[direction];
	}
	
	public boolean seen()
	{
		return squareSeen;
	}
	
	public boolean inView()
	{
		return squareInView;
	}
	
	public int row()
	{
		return row;
	}
	
	public int col()
	{
		return col;
	}
	
	public Treasure treasure()
	{
		return treasure;
	}
	
	public int x()
	{
		return 50 * col;
	}
	
	public int y()
	{
		return 50 * row;
	}
	
	public void setInView(boolean inView)
	{
		this.squareInView = inView;
		if (this.squareInView == true)
		{
			this.squareSeen = true;
		}
	}
	
	public void setTreasure(Treasure t)
	{
		this.treasure = t;
	}
	
	public void enter()
	{
		if (this.treasure != null)
			treasure.setFound();
	}
}