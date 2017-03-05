import mycs1.*;

public class Lab0
{
   public static void main(String[] args)
   {
	while (true){
		int base;
		long value;
		int exitVal;
		String finalVal;

		System.out.println("Enter 1 to quit.");
		exitVal = Keyboard.readInt();
		if (exitVal == 1) break;

		System.out.print("Supply a value greater than 0: ");
		value = Keyboard.readInt();

		System.out.print("Supply a base between 2 and 16: ");
		base = Keyboard.readInt();

		if (base < 2 || base > 16) throw new RuntimeException("Base is out of range 2 to 16");
		
		if (value < 0){
			finalVal = ("-" + changeBase((-1*value), base));
			System.out.println("Input Value: " + value + " Final Value: " + finalVal + " Base: " + base);
			System.out.println();
		}
		else{
			System.out.println("Input Value: " + value + " Final Value: " + changeBase(value, base) + " Base: " + base);
			System.out.println();
		}
	}
	
   }

   private static final char[] digits = {'0','1','2','3','4','5','6','7','8',
                                         '9','A','B','C','D','E','F'};

   // value must be >= 0 and base must be in 2..16

   private static String changeBase(long value,int base)
   {
      if (value < base)
         return "" + digits[(int)value];
      else
         return changeBase(value/base,base) + digits[(int)(value%base)];
   }
}
