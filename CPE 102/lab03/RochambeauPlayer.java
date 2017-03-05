import java.util.*;

public class RochambeauPlayer
{
	private String name;
	private int wins;
	private String lastThrow;

	public RochambeauPlayer(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getWins()
	{
		return wins;
	}

	public void incrementWins()
	{
		wins += 1;
	}

	public String lastThrow()
	{
		return lastThrow;
	}

	public int makeThrow()
	{
		Random rand = new Random();
		int throwType = rand.nextInt(3) + (0);
		if (throwType == 0)
			lastThrow = "ROCK";
		if (throwType == 1)
			lastThrow = "PAPER";
		if (throwType == 2)
			lastThrow = "SCISSORS";
		return throwType;
	}

	public int makeThrow(int throwType)
	{
		if (throwType == 0)
			lastThrow = "ROCK";
		if (throwType == 1)
			lastThrow = "PAPER";
		if (throwType == 2)
			lastThrow = "SCISSORS";
		return throwType;
	}

	public String toString()
	{
		return name + " has " + wins + " wins";
	}
}
