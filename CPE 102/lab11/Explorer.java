import java.util.*;

public class Explorer {

	public static void main(String[] args) {
		
		LinkedList<String> linkedString = new LinkedList<String>();
		LinkedList<Integer> linkedInteger = new LinkedList<Integer>();
		
		linkedString.add("A");
		linkedString.add("B");
		linkedString.add("C");
		linkedString.add("D");
		linkedString.add("E");
		linkedString.add("F");
		linkedString.add("G");
		linkedString.add("H");
		
		linkedInteger.add(new Integer(0));
		linkedInteger.add(new Integer(1));
		linkedInteger.add(new Integer(2));
		linkedInteger.add(new Integer(3));
		linkedInteger.add(new Integer(4));
		linkedInteger.add(new Integer(5));
		linkedInteger.add(new Integer(6));
		linkedInteger.add(new Integer(7));
		
		System.out.println(linkedString.toString());
		System.out.println(linkedInteger.toString());
		
		Iterator<String> stringIterator = linkedString.iterator();
		System.out.println("\n" + "Printing Linked String List Elements Using Basic While Loop Format");
		while (stringIterator.hasNext()) 
		{
		String nextElement = stringIterator.next();
		System.out.println(nextElement);
		}
		
		System.out.println("\n" + "Printing Linked Integer List Elements Using Condensed 'For Each' Format");
		for (Integer element : linkedInteger){
			Integer nextElement = element;
			System.out.println(nextElement);
		}
	}

}
