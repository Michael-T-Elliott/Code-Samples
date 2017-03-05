
public interface TotemPole {
	 int power();  // the total power of the pole
     int height(); // the number of heads in the pole
     boolean chiefPole(int bearCount);  // is this pole worthy of a chief?
     // bearCount is how many bears encountered in a row so far
}
