
public class Eagle implements TotemPole {

	 public Eagle(){}
	 
	 public int power() // the total power of the pole
	 {
		 return 2;
	 }
	 
     public int height() // the number of heads in the pole
     {
    	 return 1;
     }
     
     public boolean chiefPole(int bearCount)  // is this pole worthy of a chief?
     {
    	 return false;
     }
}
