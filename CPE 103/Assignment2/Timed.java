import java.util.Random;

///-----------------------------------------------------------------
///   Class:          <Timed>
///   Description:    <Generates an array of 1000 Integer objects, ordered smallest to largest.>
///                   <Calls System.currentTimeMillis( ) to get the current wallclock time.>
///                   <Calls InsertionTest.sortLinear( ) to sort the array.>
///                   <Calls System.currentTimeMillis( ) to get the new time.  Subtract the first time from this and print out the elapsed time.>
///                   <Repeat this process for 10,000 objects and 100,000 objects.  Repeat again for the sortBinary( ) method.>
///                   <Repeat all the above for arrays of Integer objects that are ordered largest to smallest.>
///                   <Repeat all the above for arrays of random Integer objects.>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <10/26/16>
///-----------------------------------------------------------------

public class Timed {
	
	public static void main(String[] args){
		
		final int max = 1000000;
		Random generator = new Random(); 
		int rand = 0;
		Integer[] x = new Integer[1000];
		int arrSize = 1000;

		
		//Fill an array ordered smallest to largest
		System.out.println("IN ORDER LINEAR SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			for(int i = 0; i < arrSize; i++){
				x[i] = i+1;
			}
			long timeBefore = System.currentTimeMillis( );
			InsertionTest.sortLinear(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in order, the Linear Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.println(" Sorting unverified");
			
			arrSize *= 10;
		}
		
		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		//Fill an array of Integer objects, ordered largest to smallest
		System.out.println("REVERSE ORDER LINEAR SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			int len = x.length;
			for(int i = 0; i < arrSize; i++){
				x[i] = len;
				len--;
			}
			long timeBefore = System.currentTimeMillis( );
			InsertionTest.sortLinear(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in reverse order, the Linear Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.println(" Sorting unverified");
			arrSize *= 10;
		}

		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		//Sort a Randomly filled array of Integer objects with linear
		System.out.println("RANDOM ORDER LINEAR SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			for(int i = 0; i < arrSize; i++){
				rand = generator.nextInt(arrSize) + 1;
				x[i] = rand;
			}
			long timeBefore = System.currentTimeMillis( ) ;
			InsertionTest.sortLinear(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in random order, the Linear Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.println(" Sorting unverified");
			arrSize *= 10;
		}

		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		//Sort an array ordered smallest to largest with binary
		System.out.println("IN ORDER BINARY SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			for(int i = 0; i < arrSize; i++){
				x[i] = i+1;
			}
			long timeBefore = System.currentTimeMillis( );
			InsertionTest.sortBinary(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in order, the Binary Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.println(" Sorting unverified");
			arrSize *= 10;
		}
		
		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		//Fill an array of Integer objects, ordered largest to smallest
		System.out.println("REVERSE ORDER BINARY SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			int len = x.length;
			for(int i = 0; i < arrSize; i++){
				x[i] = len;
				len--;
			}
			long timeBefore = System.currentTimeMillis( );
			InsertionTest.sortBinary(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in reverse order, the Binary Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.print(" Sorting unverified");
			arrSize *= 10;
		}
		
		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		
		//Sort a Randomly filled array of Integer objects with linear
		System.out.println("RANDOM ORDER BINARY SEARCH");
		while(arrSize < max){
			x = new Integer[arrSize];
			for(int i = 0; i < arrSize; i++){
				rand = generator.nextInt(arrSize) + 1;
				x[i] = rand;
			}
			long timeBefore = System.currentTimeMillis( );
			InsertionTest.sortBinary(x);
			long timeAfter = System.currentTimeMillis( );
			long totalMillis = timeAfter - timeBefore;
			float totalSecs = (float)totalMillis/1000;
			
			System.out.print("For " + arrSize + " objects in random order, the Binary Search sort time is " + totalSecs + " seconds;");
			if (isSorted(x)) System.out.println(" Sorting verified");
			else System.out.println(" Sorting unverified");
			arrSize *= 10;
		}

		arrSize = 1000;
		System.out.println("-----------------------------------------------------------------------------------------------------------");

	}
	
	//Method tests final list (after each of the 18 runs) is indeed sorted
	public static boolean isSorted(Comparable[] x){
		boolean sorted = true;

		for (int i = 0; i < x.length - 1; i++) {
		    if (x[i].compareTo(x[i+1]) > 0) {
		        sorted = false;
		        break;
		    }
		}
		
		return sorted;
	}

}
