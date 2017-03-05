import java.util.*;

public class IntegerList {

	private ArrayList<Integer> Integers = new ArrayList<Integer>();
	
	public IntegerList(int num, int max){
		Random rand = new Random();

		for (int i = 0; i < num; i++)
			Integers.add(rand.nextInt(max));
	}
	
	public void sort() {
//sort the list of Integer objects
		Collections.sort(Integers);
	}
	
	public void sort(Comparator<Integer> comparator){
//sort the list of Integer objects according to the specified Comparator
		Collections.sort(Integers, comparator);
	}
	
	public boolean isSorted(Comparator<Integer> comparator){
//check to see if the list is in the order specified by the provided Comparator
//If the Comparator parameter is null the method will check to see if the list is in the natural order specified by the compareTo method of the Integer class
//returns true if the list is in the specified order, otherwise false
		ArrayList<Integer> copy = new ArrayList<Integer>(Integers.size());

		for (int i = 0; i < copy.size(); i++){
			copy.add(Integers.get(i));
		}

		if(comparator == null){
			Collections.sort(copy);
			if (Integers.equals(copy)){
				return true;
			}
		}

		else{
			Collections.sort(copy, comparator);
			if (Integers.equals(copy)){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
//returns a String containing each integer value on its own line
		String s = "";
		if (Integers.size() != 0)
		{
			for (int i = 0; i < Integers.size(); i++)
			{
				s += (Integers.get(i) + "\n");
			}
		}
		return s;
	}
	
}
