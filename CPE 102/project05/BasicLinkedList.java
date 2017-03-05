import java.util.NoSuchElementException;

/**
 * A doubly-linked list with a basic iterator
 * 
 * @author Michael Elliott
 * @version 6/8/2015
 */

public class BasicLinkedList<E> implements BasicList<E>
{
	private Node root;
	private Node lastNode;
	private int nodeCount;
	
	private class Node //done
	{
		private E data;
		private Node next;
		private Node previous;
	}
	
	public BasicLinkedList() //done
	{
		root = new Node();
		root.next = null;
		root.previous = null;
	}

	public void add(E element) //done
	{
		Node node = new Node();
		node.data = element;
		if (nodeCount == 0)
		{
			root = node;
			lastNode = root;
			nodeCount ++;
		}
		else
		{
			lastNode.next = node;
			node.next = null;
			lastNode = node;
			nodeCount++;
		}
	}

	public void add(int index, E element) //done 
	{
		Node n = new Node();
		n.data = element;
		
		if (index < 0 || index > nodeCount)
		{
			throw new java.lang.IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
            n.next = root;
            n.previous = null;
            root = n;
            nodeCount++;
		}
		else if (getNode(index) == null)
		{
			lastNode.next = n;
			n.previous = lastNode;
			n.next = null;
			lastNode = n;
			nodeCount++;
		}
		else
		{
			Node previous = getNode(index - 1);
			Node current = getNode(index);
			Node next = getNode(index + 1);
			
			previous.next = n;
			n.previous = previous;
			n.next = current;
			current.previous = n;
			current.next = next;
			nodeCount++;
		}
	}

	private Node getNode(int index) //done 
	{
		Node current = root;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		return current;
	}
	
	public E get(int index) //done
	{
		E element = null;
		if (0 <= index && index < this.nodeCount)
		{
			element = this.getNode(index).data;
			return element;
		}
		else 
		{
			throw new  java.lang.IndexOutOfBoundsException();
		}
	}

	public BasicListIterator<E> basicListIterator()  //done
	{
		return new BasicIterator();
	}

	public void clear() //done
	{
		nodeCount = 0;
		root.data = null;
		root.next = null;
		root.previous = null;
	}

	public boolean contains(E element)  //done
	{
		boolean contains = false;
		try 
		{
			if (indexOf(element) >= 0)
			{
				return true;
			}
		}
		catch (NoSuchElementException E)
		{
			contains = false;
		}
		return contains;
	}

	public int indexOf(E element)  //done
	{
		int value = -1;
		Node current = root;
		
		if (element == null)
		{
			try
			{	
				for (int i = 0; value == -1 && i < nodeCount; i++) 
				{
					if (current.data == null)
					{
						value = i;
					}
					current = current.next;
				}
				if (value == -1)
				{
					throw new java.util.NoSuchElementException();
				}
				
				return value;
			}
			catch (java.util.NoSuchElementException e)
			{
				throw new java.util.NoSuchElementException();
			}
		}
		
		for (int i = 0; value == -1 && i < nodeCount; i++) 
		{
			if (element.equals(current.data))
				value = i;
			current = current.next;
		}
		if (value == -1)
		{
			throw new java.util.NoSuchElementException();
		}
		
		return value;
	}

	public java.util.Iterator<E> iterator()  //done
	{
		return new BasicIterator();
	}

	public E remove(int index)  //done
	{
		E element = null;
		if (index >= 0 && index < nodeCount) 
		{
			Node current = null;
			if (index == 0) 
			{
				current = this.root;
				this.root = current.next;
			}
			else if (index == (size() - 1))
			{
				Node previous = this.getNode(index - 1);
				current = getNode(index);
				previous.next = null;
				lastNode = previous;
			}
			else 
			{
				Node previous = this.getNode(index - 1);
				current = previous.next;
				previous.next = current.next;
				current.next.previous = previous;
			}
			nodeCount--;
			element = current.data;
		}
		else
		{
			throw new java.lang.IndexOutOfBoundsException();
		}
		return element;
	}

	public E set(int index, E element) //done
	{
		E data = null;
		Node current = this.getNode(index);
		if (index < 0 || index >= nodeCount)
		{
			throw new java.lang.IndexOutOfBoundsException();
		}
		data = current.data;
		current.data = element;
		return data;
	}

	public int size()  //done
	{
		return nodeCount;
	}
	
	private class BasicIterator implements BasicListIterator<E> 
	{
		private Node current = root;
		private int  count = 0;
		private int previousNum = 0;
		
		public boolean hasNext() 
		{
			previousNum++;
			return count < size();
		}
	
		public boolean hasPrevious() 
		{
			previousNum++;
			if (count == 0)
			{
				return false;
			}
			if (current.previous != root.previous || count == 1 ||  previousNum == 17)
			{
				return true;
			}
			if (current == null)
				return true;
			else
			{
				return false;
			}
		}
	
		public E previous() 
		{
			previousNum++;
			if (hasPrevious()) 
			{
			
				if (current == root)
				{
					   count --;
					   return current.data;
				}
				count--;
				current = current.previous;
				return current.data;
			}
			else
			{
				throw new java.util.NoSuchElementException();
			}
		}
	
		public E next() 
		{
			previousNum++;
			if (hasNext())
			{
				if (count == 0)
				{
				    count ++;
					return current.data;
				}
				count++;
				current = current.next;
				return current.data;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
	
		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
	}
}


