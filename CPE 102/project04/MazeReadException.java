/**
 * MazeReadException.java
 * Maze Exception Class that contains all the logic to throw an exception for Maze.
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */

public class MazeReadException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String line;
	private int lineNumber;
	
	public MazeReadException(String message, String line, int lineNumber){
		super(message);
		this.line = line;
		this.lineNumber = lineNumber;
	}
	
	public String getLine()
	{
		return this.line;
	}
	
	public int getLineNum()
	{
		return this.lineNumber;
	}

}
