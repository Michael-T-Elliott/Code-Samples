
/**
 * A simple integer counter.
 */
public class Counter {
  
  private int count; // current count
  private int maxValue; // max value of counter
  private int preValue; //previous value of counter
  private boolean wasReset; // T/F Check if reset
  
  // Constructors:
  
  /**
   * Create a new Counter, with the count initialized
   * to 0.
   */
  public Counter (int maxValue) 
  {
    this.maxValue = maxValue;
    count = 0;
  }
  
  // Queries (Accessors):
  
  /**
   * The number of items counted.
   */
  public int currentCount () 
  {
    return count;
  }
  
  // Commands (Mutators):
  
  /**
   * Increment the count by 1.
   */
  public void incrementCount () 
  {
    count = count + 1;
    if (count >= maxValue)
    {
      reset();
    }
  }
  
  /**
   * Reset the count to 0.
   */
  public void reset () 
  {
    preValue = count;
    if (preValue >= maxValue)
    {
    preValue = count - 1;
    }
    count = 0;
    wasReset = true;
  }

  /**
  * Unreset the count to value before reset
  */
  public void unReset()
  {
    if (wasReset == true)
    {
    count = preValue;
    }
    if (wasReset != true)
    {
      System.out.println("Error: unReset() ran before reset(), no change in count made.");
    }
  }

}