public class TestCartesianPoint
{
   public static void main(String[] args)
   {
      // test methods
      testConstructor();
      testAngle();
      testDistance();
      testRadius();
      testRotate();

      // results
      System.out.println("\nTests: " + SUnit.testsRun());
      System.out.println("Failures: " + SUnit.testsFailed());

      if (SUnit.testsFailed() == 0)
         System.out.println("\nPASSED ALL TESTS!!!");
   }

   private static void testConstructor()
   {
      int fails = SUnit.testsFailed();

      System.out.println("Testing constructor...");
      CartesianPoint cp = new CartesianPoint(2.1,4.7);
      SUnit.assertEquals(2.1, cp.xCoordinate(), .000001);
      SUnit.assertEquals(4.7, cp.yCoordinate(), .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testAngle()
   {
   	  int fails = SUnit.testsFailed();

      System.out.println("Testing Angle...");
      CartesianPoint cp = new CartesianPoint(2, 4);
      SUnit.assertEquals(cp.angle(), 1.107148717794, .000001);

      CartesianPoint cp2 = new CartesianPoint(3, 5);
      SUnit.assertEquals(cp2.angle(), 1.0303768265243125, .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testDistance()
   {
   	  int fails = SUnit.testsFailed();

      System.out.println("Testing Distance...");
      CartesianPoint cp = new CartesianPoint(2, 4);
      CartesianPoint cp2 = new CartesianPoint(3, 5);
  
      SUnit.assertEquals(cp.distanceFrom(cp2), 1.41421356237, .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testRadius()
   {
   	  int fails = SUnit.testsFailed();

      System.out.println("Testing Radius...");
      CartesianPoint cp = new CartesianPoint(2, 4);
  
      SUnit.assertEquals(cp.radius(), 4.47213595499958, .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testRotate()
   {
   	  int fails = SUnit.testsFailed();

      System.out.println("Testing Rotate 90...");
      CartesianPoint cp1 = new CartesianPoint(1, 2);
      CartesianPoint rcp1 = (CartesianPoint)cp1.rotate90();
      CartesianPoint tcp1 = new CartesianPoint(-2, 1);

      CartesianPoint cp2 = new CartesianPoint(2, 4);
      CartesianPoint rcp2 = (CartesianPoint)cp2.rotate90();
      CartesianPoint tcp2 = new CartesianPoint(-4, 2);
  
      SUnit.assertEquals(rcp1.xCoordinate(), tcp1.xCoordinate(), .000001);
      SUnit.assertEquals(rcp2.yCoordinate(), tcp2.yCoordinate(), .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }


}
