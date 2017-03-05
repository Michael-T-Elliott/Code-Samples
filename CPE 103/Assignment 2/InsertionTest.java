///-----------------------------------------------------------------
///   Class:          <InsertionTest>
///   Description:    <Sorts an array of Comparable objects>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <10/26/16>
///-----------------------------------------------------------------

public class InsertionTest {
	
	//Linear Insertion Sort method
	public static void sortLinear(Comparable[] x){ 
	    int n = x.length;
	    int ins;
	    int j;
	    Comparable item;
	    
	    for (int i = 1; i < n; ++i)
	    {
	        j = i - 1;
	        item = x[i];
	        ins = linearSearch(x, item, j);
	 
	        while (j >= ins)
	        {
	            x[j+1] = x[j];
	            j--;
	        }
	        x[j+1] = item;
	    }
	}

	//Binary Insertion Sort Method
	public static void sortBinary(Comparable[] x){
	    int n = x.length;
	    int ins;
	    int j;
	    Comparable item;
	    
	    for (int i = 1; i < n; ++i)
	    {
	        j = i - 1;
	        item = x[i];
	        ins = binarySearch(x, item, 0, j);
	 
	        while (j >= ins)
	        {
	            x[j+1] = x[j];
	            j--;
	        }
	        x[j+1] = item;
	    }
	}
	
	//Linear Search Method (Determines Where Array Element Should Be Inserted)
	public static int linearSearch(Comparable x[], Comparable item, int left){
        while (left >= 0 && item.compareTo(x[left]) < 0) {  
            left--;
        }  
        return left+1;
	}
	
	//Recursive Binary Search Method (Determines Where Array Element Should Be Inserted)
	public static int binarySearch(Comparable x[], Comparable item, int left, int right)
	{
	    if (right <= left){
	    	if(item.compareTo(x[left]) > 0){
	    		return left+1;
	    	}
	    	else{
	    		return left;
	    	}
	    }
	 
	    int mid = (left + right)/2;
	 
	    if(item == x[mid]){
	        return mid+1;
	    }
	 
	    if(item.compareTo(x[mid]) > 0){
	        return binarySearch(x, item, mid+1, right);
	    }
	    
	    return binarySearch(x, item, left, mid-1);
	}
}
