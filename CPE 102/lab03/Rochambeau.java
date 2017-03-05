public class Rochambeau
{
	//instance variables
	public static int ROCK = 0;
	public static int PAPER = 1;
	public static int SCISSORS = 2;


	//methods
	public static int getWinner(int throw1, int throw2)
	{
		if ((throw1 == 1 && throw2 == 0) || (throw1 == 0 && throw2 == 2) || (throw1 == 2 && throw2 == 1))
		{
			return 1;
		}
		if ((throw2 == 1 && throw1 == 0) || (throw2 == 0 && throw1 == 2) || (throw2 == 2 && throw1 == 1))
		{
			return -1;
		}
		else
		{
			return 0;
		}

	}
	//Determines the winner given two Rochambeau throws
}
