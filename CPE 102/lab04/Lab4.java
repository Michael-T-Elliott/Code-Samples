import java.util.*;

public class Lab4
{
	public static void main(String[] args)
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Double>  dubList = new ArrayList<Double>();
		ArrayList<Object>  objList = new ArrayList<Object>();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an int, double, any random text, or type quit to end: ");

		while (sc.hasNext("quit") != true)
		{
			System.out.print("Enter an int, double, any random text, or type quit to end: ");
			if (sc.hasNextInt() == true)
			{
				int typed_int = sc.nextInt();
				intList.add(new Integer(typed_int));
				sc.nextLine();
			}

			else if (sc.hasNextDouble() == true)
			{
				double typed_dub = sc.nextDouble();
				dubList.add(new Double(typed_dub));
				sc.nextLine();
			}

			else //(sc.hasNext() == true)
			{
				String typed_obj = sc.nextLine();
				objList.add((typed_obj));
			}

		}

		if (sc.hasNext("quit") == true)
		{
			System.out.println("Integers:");
			int index = 0;
			for (Integer i: intList)
			{
				System.out.println("Integer[" + (index++) + "] is " + i);
			}

			System.out.println("Doubles:");
			index = 0;
			for (Double d: dubList)
			{
				System.out.println("Double[" + (index++) + "] is " + d);
			}

			System.out.println("Other:");
			index = 0;
			for (Object o: objList)
			{
				System.out.println("Other[" + (index++) + "] is " + o);
			}
		}
		
	}
}