///-----------------------------------------------------------------
///   Class:          <ItemRecord>
///   Description:    <Creates ItemRecord object with a string token and a flag boolean>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <11/28/16>
///-----------------------------------------------------------------

public class ItemRecord implements Comparable<ItemRecord>{
	
	public String token;
	public boolean flag;
	
	//constructs ItemRecord
	public ItemRecord(String token, boolean flag){
		this.token = token;
		this.flag = flag;
	}
	
	//Overload method for ItemRecord with no boolean argument, boolean is false by default (saves typing when not using flags i.e. spellCheck)
	public ItemRecord(String token){
		this.token = token;
		this.flag = false;
	}

	//compareTo method for ItemRecord, merely compares String as flag is unimportant for comparison purposes
	public int compareTo(ItemRecord other) {
		return this.token.toLowerCase().compareTo(other.token.toLowerCase());
	}
	
}
