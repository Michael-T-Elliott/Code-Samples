/**
 * DelimitedTextIO.java
 * Interface which creates toText and toObject method and uses a delimiter character.
 * 
 * @author Michael Elliott Section 10
 * @version 5-26-15
 */

import java.util.Scanner;

public interface DelimitedTextIO {

	public String toText(char delimiter);
	public void toObject(Scanner input);
}
