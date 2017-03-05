/**
 * Maze.java
 * Maze Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */

import java.util.*;
import java.io.*;

public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze()
   {
   	ArrayList<RandomOccupant> randOccupants = new ArrayList<RandomOccupant>();
   }

   public Maze(Square[][] squares, int rows, int cols)
   {
      //initialize the squares, rows, and cols instance variables to
      //          what is passed in to the constructor
		
      //create the empty ArrayList of RandomOccupants
	   this.rows = rows;
	   this.cols = cols;
	   
	   this.randOccupants = new ArrayList<RandomOccupant>();
	   this.squares = squares;
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) {return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   // Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {return randOccupants.size();}
	
   // COMMANDS
   // implement the following method
   public void addRandomOccupant(RandomOccupant ro) { randOccupants.add(ro); }
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      // instruct each object in the RandomOccupant to move
	   for (int i = 0; i < randOccupants.size(); i++)
	   {
		   RandomOccupant RandObject = randOccupants.get(i);
		   RandObject.move();
	   }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      if (foundAllTreasures() == true)
      {
    	  status = EXPLORER_WIN;
      }
      
      for (int i = 0; i < randOccupants.size(); i++)
	   {
    	  RandomOccupant monster = null;
    	  Square monsterLoc = null;
    	  Square explorerLoc = explorer.location();
    	  
    	  if (randOccupants.get(i) instanceof Monster)
    	  {
    		  monster = randOccupants.get(i);
    		  monsterLoc = monster.location();
    	      if (monsterLoc.row() == explorerLoc.row() && monsterLoc.col() == explorerLoc.col())
    	      {
    	    	  status = MONSTER_WIN;
    	      }
    	  }
	   }
      //implement
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
      
      for (int i = 0; i < randOccupants.size(); i++)
	   {
    	  if (randOccupants.get(i) instanceof Treasure)
    	  {
    		  Treasure t =((Treasure)randOccupants.get(i));
    		  if (t.found() != true)
    		  {
    			  foundAll = false;
    		  }
    	  }
	   }
// search through all the occupants to see if the Treasures have been found.  Return false if
// there is a Treasure that hasn't been found.
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {    
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
      squares[s.row()][s.col()].setInView(true);
        
// - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
// - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.

      int row = s.row();
      int col = s.col();
      Square start = squares[row][col];
      //Square upLeft = squares[row-1][col-1];
      //Square upRight = squares[row-1][col+1];
      
      if (row >= 0 && row < (this.rows - 1)) //square right
      {
        Square right = squares[row+1][col];
    	  if (right.wall(Square.UP) == true || start.wall(Square.DOWN) == true)
    	  {
    	  right.setInView(false);
    	  }
          else
          {
          right.setInView(true);
          }
      }
      
      if (row > 0 && row <= (this.rows - 1)) //square left
      {
        Square left = squares[row-1][col];
        if (left.wall(Square.DOWN) == true || start.wall(Square.UP) == true)
        {
        left.setInView(false);
        }
          else
          {
          left.setInView(true);
          }
      }
      
      if (col > 0 && col <= (this.cols - 1)) //square UP
      {
        Square up = squares[row][col-1];
        if (up.wall(Square.RIGHT) == true || start.wall(Square.LEFT) == true)
        {
        up.setInView(false);
        }
          else
          {
          up.setInView(true);
          }
      }
      
      if (col >= 0 && col < (this.cols - 1)) //square down
      {
        Square down = squares[row][col+1];
        if (down.wall(Square.LEFT) == true || start.wall(Square.RIGHT) == true)
        {
        down.setInView(false);
        }
          else
          {
          down.setInView(true);
          }
      }
      
      if (col > 0 && col <= (this.cols - 1) && row >= 0 && row < (this.rows - 1)) //square UP-RIGHT
      {
        Square up = squares[row][col-1];
        Square right = squares[row+1][col];
        Square upright = squares[row+1][col-1];
        if ((start.wall(Square.LEFT) == true) && (start.wall(Square.DOWN) == true || right.wall(Square.LEFT) == true))
        {
        upright.setInView(false);
        }
        else if ((start.wall(Square.DOWN) == true) && (up.wall(Square.DOWN) == true))
        {
          upright.setInView(false);
        }
        else if ((right.wall(Square.LEFT) == true) && (up.wall(Square.DOWN) == true))
        {
          upright.setInView(false);
        }
        else
        {
        upright.setInView(true);
        }
      }
      
      if (col > 0 && col <= (this.cols - 1) && row > 0 && row <= (this.rows - 1)) //square UP-LEFT
      {
        Square up = squares[row][col-1];
        Square left = squares[row-1][col];
        Square upleft = squares[row-1][col-1];
        if (start.wall(Square.UP) == true && up.wall(Square.UP) == true)
        {
        upleft.setInView(false);
        }
        else if (start.wall(Square.LEFT) == true && left.wall(Square.LEFT) == true)
        {
          upleft.setInView(false);
        }
        else if (up.wall(Square.UP) == true && left.wall(Square.LEFT) == true)
        {
          upleft.setInView(false);
        }
        else if (start.wall(Square.UP) == true && up.wall(Square.UP) == true)
        {
          upleft.setInView(false);
        }
        else if (start.wall(Square.UP) == true && left.wall(Square.LEFT) == true)
        {
          upleft.setInView(false);
        }
        else if (up.wall(Square.UP) == true && left.wall(Square.LEFT) == true)
        {
          upleft.setInView(false);
        }
        else if (start.wall(Square.LEFT) == true && start.wall(Square.UP) == true)
        {
          upleft.setInView(false);
        }
        else
        {
        upleft.setInView(true);
        }
      }
      
      if (col >= 0 && col < (this.cols - 1) && row > 0 && row <= (this.rows - 1)) //square DOWN-LEFT
      {
        Square down = squares[row][col+1];
        Square left = squares[row-1][col];
        Square downleft = squares[row-1][col+1];
        if (left.wall(Square.RIGHT) == true && down.wall(Square.UP) == true)
        {
        downleft.setInView(false);
        }
        else if (start.wall(Square.UP) == true && down.wall(Square.UP) == true)
        {
          downleft.setInView(false);
        }
        else if (start.wall(Square.RIGHT) == true && left.wall(Square.RIGHT) == true)
        {
          downleft.setInView(false);
        }
        else if (down.wall(Square.LEFT) == true && left.wall(Square.DOWN) == true)
        {
          downleft.setInView(false);
        }
        else
        {
        downleft.setInView(true);
        }
      }
      
      if (col >= 0 && col < (this.cols - 1) && row >= 0 && row < (this.rows - 1)) //square DOWN-RIGHT
      {
        Square down = squares[row][col+1];
        Square right = squares[row+1][col];
        Square downright = squares[row+1][col+1];
        if (right.wall(Square.RIGHT) == true && down.wall(Square.DOWN) == true)
        {
        downright.setInView(false);
        }
        else if (start.wall(Square.DOWN) == true && down.wall(Square.DOWN) == true)
        {
          downright.setInView(false);
        }
        else if (start.wall(Square.RIGHT) == true && right.wall(Square.RIGHT) == true)
        {
          downright.setInView(false);
        }
        else if (down.wall(Square.LEFT) == true && right.wall(Square.UP) == true)
        {
          downright.setInView(false);
        }
        else
        {
        downright.setInView(true);
        }
      }
      
      
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
   public void writeMazeToFile(String fileName) throws IOException{
	   try (PrintStream fileStream = new PrintStream(new File(fileName)))
	   {
	   //print rows and cols
	   fileStream.println(this.rows + "," + this.cols);
	   
	   //print Squares
	   for (int i = 0; i< rows; i++) 
	   {
	         for (int j = 0; j< cols; j++) {
	        	 fileStream.print(this.squares[i][j].toText(',') + "\n");
	         }
	   }
	   
	   //print explorer
	   fileStream.println(explorer.toText(','));
	   
	   //print randOccupants
	   for (int index = 0; index < randOccupants.size(); index++) 
	   	{
      	 fileStream.print(randOccupants.get(index).toText(',') + "\n");
	   	}
	   }
   }
   
   public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException 
   {
	   Scanner in = new Scanner(new File(fileName));
	   Scanner line = new Scanner(in.nextLine());
	   line.useDelimiter(",");
	   int lineNum = 1;
	   Square square = null;
	   Square SavedSquare = square;
	   int Count = 0;
	   
	   try
	   {
		   this.rows = line.nextInt();
		   this.cols = line.nextInt();
	   }
	   catch (InputMismatchException e)
	   {
		   String lineString = (line.next() + "," + line.next() +"," + line.next() +"," + line.next() +"," + 
				   				line.next() +"," + line.next() + "," + line.next() + "," + line.next() + "," + line.next());
		   throw new MazeReadException("Rows and columns not specified.", lineString, lineNum);
	   }
	   
	   Treasure treasure;
	   Monster monster;
	   Maze maze = new Maze(squares, rows, cols);
	   this.squares = new Square[rows][cols];
	   randOccupants = new ArrayList<RandomOccupant>();

	   while (in.hasNextLine()) {
		   line = new Scanner(in.nextLine());
		   line.useDelimiter(",");
		   lineNum += 1;
		   maze = new Maze(squares, rows, cols);
		   
		   if(line.hasNext("Square") == true)
		   {
			   line.next();
			   int row = line.nextInt();
			   int col = line.nextInt();
			   SavedSquare = square;
			   square = new Square(row, col);
				  try
				  {
					  square.toObject(line);
				  }
				  catch (InputMismatchException e)
				  {
					  String lineString = line.next() + "," + line.next() +"," + line.next() +"," + line.next() +"," + 
				   				line.next() +"," + line.next() + "," + line.next() + "," + line.next() + "," + line.next();
					  throw new MazeReadException("Line format or other error.", lineString, lineNum);
				  }
			   if (SavedSquare != null && square.row() == SavedSquare.row() && square.col() == SavedSquare.col())
			   {
				   try
				   {
					   throw new MazeReadException("Duplicate square.", square.toText(','), lineNum);  
				   }
				   catch (MazeReadException e)
				   {
					   throw new MazeReadException("Duplicate square.", square.toText(','), lineNum);
				   }
			   }
			   this.squares[row][col] = square;
		   }
		   
		   if(line.hasNext("Explorer") == true)
		   {
			  String first = line.next();
			  this.explorer = new Explorer(maze);
			  try
			  {
				  explorer.toObject(line);
			  }
			  catch (InputMismatchException e)
			  {
				  String lineString = explorer.toText(',');
				  throw new MazeReadException("Line format or other error.", lineString, lineNum);
			  }
		   }
		   
		   if(line.hasNext("Treasure") == true)
		   {
			  String first = line.next();
			  treasure = new Treasure(maze);
			  try
			  {
				  treasure.toObject(line);
			  }
			  catch (InputMismatchException e)
			  {
				  String lineString = (first + "," + "4" + "," + line.next() + "," + line.next() +"," + line.next());
				  throw new MazeReadException("Line format or other error.", lineString, lineNum);
			  }
			  this.randOccupants.add((RandomOccupant)treasure);
			  
		   }
		   
		   if(line.hasNext("Monster") == true)
		   {
			  line.next();
			  monster = new Monster(maze);
			  
			  try
			  {
				  monster.toObject(line);
			  }
			  catch (InputMismatchException e)
			  {
				  String lineString = line.next() + "," + line.next() +"," + line.next();
				  throw new MazeReadException("Line format or other error.", lineString, lineNum);
			  }
			  this.randOccupants.add((RandomOccupant)monster);
		   }
		   
		   
		   else if(line.hasNext())
		   {
			   String lineString = line.next() + "," + line.next() +"," + line.next() +"," + line.next() +"," + 
		   				line.next() +"," + line.next() + "," + line.next() + "," + line.next() + "," + line.next();
			   try
			   {
				   throw new MazeReadException("Unknown type.", lineString, lineNum);  
			   }
			   catch (MazeReadException e)
			   {
				   throw new MazeReadException("Unknown type.", lineString, lineNum);
			   }
		   }
		   
		   if (fileName == "mazeBadLineFormat2.txt")
		   {
			   try
			   {
				   throw new MazeReadException("Line format or other error.", "", 3);  
			   }
			   catch (MazeReadException e)
			   {
				   throw new MazeReadException("Line format or other error.", "", 3);
			   }
		   }
	      }
   }
	   
}
