
public class Snake implements TotemPole {

	TotemPole rest;
	
	 public Snake(TotemPole rest){
		 this.rest = rest;
	 }
	 
	 public int power() // the total power of the pole
	 {
		 return 3 + rest.power();
	 }
	 
     public int height() // the number of heads in the pole
     {
    	 return 1 + rest.height();
     }
     
     public boolean chiefPole(int bearCount)  // is this pole worthy of a chief?
     {
    	 return rest.chiefPole(0);
     }
}
