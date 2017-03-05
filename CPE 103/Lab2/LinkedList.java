import java.io.*;
import java.util.ListIterator;

public class LinkedList implements Cloneable
{

   private class Node
   {
      private Object item;
      private Node next;
      private Node prev;

      private Node(Object x)
      {
         item = x;
         next = null;
         prev = null;
      }
   }

   private class ITR implements ListIterator{
	private Node current;

	public ITR(){
		current = first;
	}

	public void remove(){
		if(hasNext()){
			current.next.prev = current.prev;
			current.prev.next = current.next;
			length--;
		}
		//throw new RuntimeException();
	}

	public void add(Object item){
		throw new Error("Not implemented");
	}

	public void set(Object item){
		throw new Error("Not implemented");
	}

	public int previousIndex(){
		throw new Error("Not implemented");
	}

	public int nextIndex(){
		throw new Error("Not implemented");
	}

	public boolean hasPrevious(){
		throw new Error("Not implemented");
	}

	public boolean hasNext(){
		return !(current == null);
	}
	
	public Object next(){
		if(current == null){
			throw new Error("No more items in list");
		}
		Object x = current.item;
		current = current.next;
		return x;
	}

	public Object previous(){
		Object x = current.item;
		current = current.prev;
		return x;
	}
   }

   // Self explanatory instance variables

   private Node first;
   private Node last;
   private int length = 0;

   // Default Constructor

   public LinkedList(){
      first = null;
      last = null;
      length = 0;
   }

   // Insert the given object at the beginning of the list.

   public void addFirst(Object item)
   {
      // Supply details as in the assignment description
	Node added = new Node(item);
	Node temp = first;

	if(isEmpty()){
		first = added;
		last = first;
	} else if(this.length == 1){
		first = added;
		first.next = last;
		last.prev = first;
	} else{
		first.next.prev = temp;
		first = added;
		temp.prev = first;
		first.next = temp;
		added = first;
	}
	this.length++;
   }

   // Insert the given object at the end of the list.

   public void addLast(Object item)
   {
      // Supply details as in the assignment description
	Node N = new Node(item);
	if(length == 0 || last == null){
		last = N;
		first = N;
		length += 1;
	}
	else{
		N.prev = last;
		last.next = N;
		last = N;
		length += 1;
	}
   }

   // Return the number of items in the list

   public int length()
   {
      // Supply details as in the assignment description
	return length;
   }

   // Determine if the list contains no items

   public boolean isEmpty()
   {
      // Supply details as in the assignment description
	return (length == 0);
   }

   // (Virtually) remove all items from the list

   public void clear()
   {
      first = null;
      last = null;
      length = 0;
   }

   // Determine if the list contains the given item

   public boolean contains(Object item)
   {
      // Supply details as in the assignment description
	Node Current = first;
	if(this.isEmpty() == true) return false;
	while(Current != null){
		if(Current.item.equals(item)){
			return true;
		}
	Current = Current.next;
	}
	return false;
   }

   // Remove first item on the list and return it
   
   public Object removeFirst()
   {
      // Supply details as in the assignment description
	if (isEmpty())throw new Error("No elements in the LinkedList to remove first.");
	Object removed = first.item;
	first = first.next;	
	if(first == null)
		last = null;
	length--;
	return removed;
   }

   // Remove last item on the list and return it
   
   public Object removeLast()
   {
      // Supply details as in the assignment description
	if (isEmpty())throw new Error("No elements in the LinkedList to remove last.");
	
	Object removed = last.item;
	last = last.prev;
	if(last == null)
		first = null;
	else
      		last.next = null;
	length--;
	return removed;
   }
   
   // Determine if two LinkedLists are equal
      
   public boolean equals(Object x)
   {
      // Supply details as in the assignment description
	if(x == null) return false;
	if(!(x instanceof LinkedList)) return false;
	LinkedList List = (LinkedList)x;
	if (List.length != this.length) return false;
	Node P = this.first;
	Node Q = List.first;
	while(P != null){
		if(!(P.item.equals(Q.item))) return false;
		P = P.next; 
		Q = Q.next;
	}
	return true;		
	
   }

    public boolean remove(Object item){
	ListIterator itr = new ITR();
	if(this.isEmpty()) return false;

	if(first.item.equals(item)){
		this.removeFirst();
		return true;
	}

	if(last.item.equals(item) && length == 2){
		this.removeLast();
		return true;
	}
	
	while(itr.hasNext()){
		if(itr.next().equals(item)){
			itr.previous();
			itr.remove();
			return true;
		}
	}
   	return false;
    }

   public Object clone(){
	LinkedList TheClone = new LinkedList();
	Node P = this.first;
	while(P!= null){
		TheClone.addLast(P.item);
		P = P.next;
	}
	return TheClone;
   }

   public ListIterator iterator(){
	return new ITR();
   }

   // **********************************************************************

   // FOR THE PURPOSES OF THIS LAB, YOU DON'T NEED TO SPEND TIME READING THE
   // REST OF THIS FILE.  HOWEVER, YOU SHOULD DO SO LATER ON YOUR OWN TIME.

   // The following specifies the maximum number of items in the list that
   // will be included in the toString method.
 
   private static int printLimit = 20;

   // This method allows the client to control the number of list items
   // that will be included in the toString method.

   public static void setPrintLimit(int limit)
   {
      if (limit >= 1)
         printLimit = limit;
   }

   // This method produces a string of the form {item1,item2,...} where item1 
   // is the first item in the list. The number of items included is the smaller 
   // of the number of items in the list and the value of printLimit. The "..."
   // is shown only if there are list items that were not included.  

   public String toString()
   {
      String answer = "{";
      int ctr = 0;
      for(Node curr=first;curr!=null;curr=curr.next)
      {
         answer = answer + curr.item;
         ++ctr;
         if (curr.next != null)
            if (ctr == printLimit)
               return answer + ",...}";
            else
               answer = answer + ",";
      }
      return answer + "}";
   }

   public static class Error extends RuntimeException
   {
      public Error(String message)
      {
         super(message);
      }
   }
}


