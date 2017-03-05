

public class HashTable{

	private int capacity;
	private LinkedList[] table;
	private int numElements;

	public HashTable(int capacity){
        	this.capacity = capacity;
		table = new LinkedList[capacity];
        }

	public void add(Object element){
		int index = Math.abs(element.hashCode() % capacity);
		if(table[index] == null){
			table[index] = new LinkedList();
		}
		table[index].addLast(element);
		numElements += 1;
        }

	public boolean contains(Object element){
        	int index = Math.abs(element.hashCode() % capacity);
		if(table[index].contains(element) && table[index] != null) return true;
		return false;
        }

	public int numElements(){
        	return numElements;
        }

	public int capacity(){
        	return this.capacity;
        }

	public int maxBucketCount(){
		int result = 0;

		for(int i = 0; i < capacity; i++){
			if(table[i] != null && result < table[i].length()){
				result = table[i].length();
			}
		}

		return result;
        }

	public int nonZeroBucketCount(){
        	int result = 0;
		for(int i =0; i< capacity; i++){
			if(table[i] != null){
				result += 1;
			}
		}
		return result;
        }

	public float avgNonZeroBucketCount(){
		float sum = 0;
		int numBuckets = 0;

		for(int i = 0; i < capacity; i++){
			if(table[i] != null){
				numBuckets++;
				sum += table[i].length();
			}
		}


        	return sum/numBuckets;
        }

	//public static class Error extends RuntimeException{
        //	public Error(String);
        //}
}
