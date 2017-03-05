public class Stack implements Cloneable
{
   private Object[] data;
   private int TOS;
   private static final int DEFAULT_SIZE = 20;
   private static int printLimit = 20;

   public Stack()
   {
      data = new Object[DEFAULT_SIZE];  
      TOS = -1;
   }

   public Stack(int initSize)
   {
      if (initSize <=1)
         initSize = DEFAULT_SIZE;
      data = new Object[initSize];  
      TOS = -1;
   }

   public int height() 
   {
      return TOS+1;
   }

   public int capacity() 
   {
      return data.length;
   }
   
   public Object clone()
   {
      // Fill in the details.  The clone must have the same capacity, height,
      // and data values (in the correct order) as the object being cloned.
      // Do not waste execution time by copying irrelevant objects in the data
      // array.
	Stack clone = new Stack();
	clone.data = new Object[this.data.length];
	for(int i = 0; i < this.data.length - 1; i++){
		clone.data[i] = this.data[i];
	}
	clone.TOS = this.TOS;
	return clone;
   }

   public boolean equals(Object x)
   {
     // The following tests are common to all implementations of "equals"
      // in this course, regardless of the class to which it applies.

      if (this == x)
         return true;
      if (x == null)
         return false;
      if (getClass() != x.getClass())
         return false;

      Stack s = (Stack) x;
      if (TOS != s.TOS)
         return false;
      for(int i=0;i<=TOS;++i)
         if (!data[i].equals(s.data[i]))
            return false;
      return true;
   }

   public void push(Object item)
   {
	if(TOS+1 == data.length){
		Object[] temp = new Object[data.length * 2];
		for(int i = 0; i < data.length - 1; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	data[TOS+1] = item;
	TOS += 1;
   }


   public static void setPrintLimit(int limit)
   {
      if (limit >= 1)
         printLimit = limit;
   }

   public String toString()
   {
      int limit = Math.min(height(),printLimit);
      String answer = "{";
      for(int i=0;i<limit;++i)
      {
         answer = answer + data[TOS-i];
         if (i != limit-1)
            answer = answer + ",";
      }
      if (height() > limit)
         answer = answer + ",...";
      return answer + "}";
   }
   
   public Object pop()
   {
      // Fill in the details as required on the assignment sheet.
	if (TOS == -1){
		throw new RuntimeException();
	}
	TOS -= 1;
	return data[TOS+1];
   }

   public Object peek()
   {
      // Fill in the details as required on the assignment sheet.
	if (TOS == -1){
		throw new RuntimeException();
	}
	Object PeekObj = data[TOS];
	return PeekObj;
   }

}



