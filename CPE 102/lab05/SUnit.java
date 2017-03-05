public class SUnit
{
   private static int testCount = 0;
   private static int failCount = 0;

   public static void assertEquals(double expect, double actual, double epsilon)
   {
      Throwable throwable = new Throwable("Error: Expected " + expect + " +/-" + epsilon + ", found " + actual);
      if(Math.abs(expect - actual) > Math.abs(epsilon))
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertEquals(long expect, long actual)
   {
      Throwable throwable = new Throwable(String.format("Error: Expected %d, found %d", expect, actual));
      if(expect != actual)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertEqualsObject(Object expect, Object actual)
   {
      Throwable throwable = new Throwable("Error: Expected object equality, found inequality");
      if(!expect.equals(actual))
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertEqualsReference(Object expect, Object actual)
   {
      Throwable throwable = new Throwable("Error: Expected reference equality, found inequality");
      if(expect != actual)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertFalse(boolean actual)
   {
      Throwable throwable = new Throwable("Error: Expected false, found true");
      if(actual)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertNotNull(Object actual)
   {
      Throwable throwable = new Throwable("Error: Expected non-null, found null");
      if(actual == null)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertNull(Object actual)
   {
      Throwable throwable = new Throwable("Error: Expected null, found non-null");
      if(actual != null)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void assertTrue(boolean actual)
   {
      Throwable throwable = new Throwable("Error: Expected true, found false");
      if(!actual)
      {
         throwable.printStackTrace();
         failCount++;
      }
      testCount++;
   }

   public static void fail()
   {
      Throwable throwable = new Throwable("Error: Explicit failure");
      throwable.printStackTrace();
      failCount++;
      testCount++;
   }

   public static int testsFailed()
   {
      return failCount;
   }

   public static int testsRun()
   {
      return testCount;
   }
}
