/**
 * Maze.java
 * Maze Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Michael Elliott Section 10
 * @version 5-6-15
 */

import java.util.*;

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
   public Square getSquare(int row, int col) { return squares[row][col]; }
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
        
// - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
// - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.

      int row = s.row();
      int col = s.col();
      Square start = squares[row][col];
      //Square upLeft = squares[row-1][col-1];
      //Square upRight = squares[row-1][col+1];
      
      if (col >= 0 && col < (this.cols - 1)) //square right
      {
          Square right = squares[row][col+1];
    	  if (right.wall(Square.LEFT) != true)
    	  {
    	  right.setInView(true);
    	  }
      }
      
      if (row >= 0 && row < (this.rows - 1)) //square down
      {
          Square down = squares[row+1][col];
		  if (down.wall(Square.UP) != true)
		  {
		  down.setInView(true);
		  }
      }
      
      if (col >= 0 && col < (this.cols+1) && col - 1 >= 0) //square left
      {
          Square left = squares[row][col-1];
    	  if (left.wall(Square.RIGHT) != true)
    	  {
    	  left.setInView(true);
    	  }
      }
      
      if (row >= 0 && row < (this.rows+1) && row - 1 >= 0) //square up
      {
          Square up = squares[row-1][col];
		  if (up.wall(Square.DOWN) != true)
		  {
		  up.setInView(true);
		  }
      }
      
      if (row >= 0 && row < (this.rows - 1) && col >= 0 && col < (this.cols - 1)) //square downRight
      {
          Square down = squares[row+1][col];
          Square right = squares[row][col+1];
          Square downRight = squares[row+1][col+1];
		  if ((down.wall(Square.UP) != true || right.wall(Square.LEFT) != true) && (downRight.wall(Square.LEFT) != true || downRight.wall(Square.UP) != true))
		  {
		  downRight.setInView(true);
		  }
      }
      
      if (row >= 0 && row < (this.rows+1) && col > 0 && col < (this.cols - 1)) //square downLeft
      {
          Square down = squares[row+1][col];
          Square left = squares[row][col-1];
          Square downLeft = squares[row+1][col-1];
		  if ((down.wall(Square.UP) != true || left.wall(Square.RIGHT) != true) && (downLeft.wall(Square.RIGHT) != true || downLeft.wall(Square.UP) != true))
		  {
		  downLeft.setInView(true);
		  }
      }
      if (row > 0 && row < (this.rows+1) && col > 0 && col < (this.cols+1)) //square upLeft
      {
          Square up = squares[row-1][col];
          Square left = squares[row][col-1];
          Square upLeft = squares[row-1][col-1];
		  if ((up.wall(Square.DOWN) != true || left.wall(Square.RIGHT) != true) && (upLeft.wall(Square.RIGHT) != true || upLeft.wall(Square.DOWN) != true))
		  {
		  upLeft.setInView(true);
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
}