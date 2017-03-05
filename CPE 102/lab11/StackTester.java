
public class StackTester {

	public static void main(String[] args) {

		System.out.println("Testing Stack<String> with given test code");
	
		 Stack<String> stack = new Stack<String>();
		 stack.push("A");
		 stack.push("B");
		 stack.push("C");
		 System.out.println(stack.pop());
		 stack.push("D");
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 
	     System.out.println("\n" + "Testing Stack<Integer> with given test code");
		 
		 Stack<Integer> stack2 = new Stack<Integer>();
		 stack2.push(new Integer(1));
		 stack2.push(new Integer(2));
		 stack2.push(new Integer(3));
		 System.out.println(stack2.pop());
		 stack2.push(new Integer(4));
		 System.out.println(stack2.pop());
		 System.out.println(stack2.pop());
		 System.out.println(stack2.pop());
		 
	     System.out.println("\n" + "Testing new Stack<Integer> with unique test code");
		 
	     Stack<String> stack3 = new Stack<String>();
		 stack3.push("B");
		 stack3.push("A");
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 stack3.push("2");
		 stack3.push("1");
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 
		 stack3.push("q");
		 stack3.push("w");
		 stack3.push("e");
		 stack3.push("r");
		 stack3.push("t");
		 System.out.println("\n" + stack3.pop());
		 stack3.push("y");
		 stack3.push("u");
		 System.out.println(stack3.pop());
		 stack3.push("i");
		 stack3.push("o");
		 stack3.push("p");
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		 System.out.println(stack3.pop());
		
	}

}
