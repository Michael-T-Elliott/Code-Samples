import java.util.*;

public class Descending implements Comparator<Integer>{

	public int compare(Integer x, Integer y){
		if(x > y)
			return -1;
		if(y > x)
			return 1;
		return 0;
	}
}
