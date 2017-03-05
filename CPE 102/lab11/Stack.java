import java.util.*;

public class Stack<Element>
{
	
	private LinkedList<Element> list = new LinkedList<Element>();
	
	public Stack()
	{
		
	}
	
	public Element push(Element e)
	{
        list.add(e);
        return e;
	}
	
	public Element pop()
	{
		return(list.remove(list.size() - 1));
	}

}
