public class MyTests
{
   public static void main(String[] args)
   {
      System.out.println("Testing assertEquals(long, long)...");
      
      System.out.println("First test, should pass.");
      SUnit.assertEquals(34, 34);
      System.out.println("Second test, should fail and print stack trace.");
      SUnit.assertEquals(34, 35);

      System.out.println("\nTests run: " + SUnit.testsRun());
      System.out.println("Tests failed: " + SUnit.testsFailed());
   }
}
