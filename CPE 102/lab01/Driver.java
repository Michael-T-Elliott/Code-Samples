public class Driver
{ 
   public static void main(String[] args)
   {
      // Declare and test a Counter object ...
      Counter ct = new Counter(3);

      //counter and auto-reset tests
      System.out.println("Initial count: " + ct.currentCount());
      ct.incrementCount();

      ct.unReset();
      System.out.println("unReset: " + ct.currentCount());


      System.out.println("Incremented once: " + ct.currentCount());
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());
      
      // unReset() test
      ct.unReset();
      System.out.println("unReset: " + ct.currentCount());

      // continue incrementing
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());

      //continue Incrementing
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());
      ct.incrementCount();
      System.out.println("Incrememted once: " + ct.currentCount());

      //manual reset() test
      ct.reset();
      System.out.println("Manual Reset: " + ct.currentCount());

      //check unReset() after manual reset()
      ct.unReset();
      System.out.println("unReset: " + ct.currentCount());
   }
}