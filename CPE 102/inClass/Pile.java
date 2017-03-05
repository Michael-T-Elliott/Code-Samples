public class Pile
{
	// instance variables
	private int numSticks;

    //constructor(s)
    public Pile(int numSticks)
    {
    	this.numSticks = numSticks;
    }

    // methods
	public void remove(int sticks)
	{
		numSticks -= sticks;
		return; //Don't assume user interface
		
	}

	public int sticks()
	{
		return numSticks;
	}
}