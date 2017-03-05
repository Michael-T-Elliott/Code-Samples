
public class Bear implements TotemPole {
	
	TotemPole rest;
	
	 public Bear(TotemPole rest){
		 this.rest = rest;
	 }
	 
	 public int power() // the total power of the pole
	 {
		 return 5 + rest.power();
	 }
	 
     public int height() // the number of heads in the pole
     {
    	 return 1 + rest.height();
     }
     
     public boolean chiefPole(int bearCount)  // is this pole worthy of a chief?
     {
    	 if (bearCount >= 2)
    		 return true;
    	 return rest.chiefPole(bearCount += 1);
     }
}
