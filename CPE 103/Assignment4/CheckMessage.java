///-----------------------------------------------------------------
///   Class:          <CheckMessage>
///   Description:    <Checks for spelling and alarm words a message text file when inputed along with 3 other text files>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <11/28/16>
///-----------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CheckMessage {
	
	public static Scanner message;
	public static Scanner ReMessage;
	public static Scanner dictionary;
	public static Scanner muslin;
	public static Scanner coffee;
	public static RecordBST alarm = new RecordBST();
	public static RecordBST spellCheck = new RecordBST();
	
	public static void main (String [ ] args) throws FileNotFoundException{
		message = new Scanner(new File(args[0]));
		dictionary = new Scanner(new File(args[1]));
		
		//While args[1] has terms, insert said terms to the spellCheck BST
		while(dictionary.hasNext()){
			spellCheck.insert(dictionary.nextLine());
		}
		
		int z = 2;
		while(z < args.length){
		Scanner temp = new Scanner(new File(args[z]));
			while(temp.hasNext()){
				alarm.insert(temp.nextLine());
			}
		z++;
		}
		
		System.out.println("Analyzing the file " + args[0] + "..." + "\n");
		
		System.out.println("Checking against the file " + args[1] + ":");
		System.out.println("these words were not found:");
		
		//While args[0] has terms check if terms are found, if not move to plural/gerund check, then to spellCheck if still not found
		while(message.hasNext()){
			StringTokenizer st = new StringTokenizer(message.nextLine());
			
		    while (st.hasMoreTokens()) {
		        String tok = st.nextToken();
		        String temp = tok;
		        String possibleWord = "";
		        
		        //check for plurals ending with "es," then removes it if term can be found without the character(s)
		        if(spellCheck.find(tok) == false && tok.endsWith("es")){
		        	tok = tok.substring(0, tok.length() - 2);
		        	
		        	if(spellCheck.find(tok) == false){
		        		tok = temp;
		        	}
		        }
		        
		      //check for plurals ending with "s," then removes it if term can be found without the character(s)
		        else if(spellCheck.find(tok) == false && tok.endsWith("s")){
		        	tok = tok.substring(0, tok.length() - 1);
		        	
		        	if(spellCheck.find(tok) == false){
		        		tok = temp;
		        	}
		        }
		        
		       //check for gerunds ending with "es," then removes it if term can be found without the character(s)
		        else if(spellCheck.find(tok) == false && tok.endsWith("ing")){
		        	tok = tok.substring(0, tok.length() - 3);
		        	
		        	if(spellCheck.find(tok) == false){
		        		tok = temp;
		        	}
		        }
		        
		        //if plural/gerund checking doesn't work, moves on to spell check
		        else if(spellCheck.find(tok) == false){
		        	String word =  tok;
		        	int i = 0;
		        	int j = 1;
		        	
		        	while(!spellCheck(word, i, j).equals("Word Not Found")){
		        		tok = spellCheck(word, i, j);
		      
		        		if(spellCheck.find(tok) == false) {
			        		tok = temp;
			        		i += 1;
			        		j += 1;
			        	}
		        		else{
		        			possibleWord = spellCheck(word, i, j);
		        			i += 1;
			        		j += 1;
		        		}
		        	}
		        	System.out.println(temp + "     possible spellings: " + possibleWord);
		        }   
		    }  
		}
		
	    System.out.print("\n" + "Checking against the alarm files");
	    
	    z = 2;
	    while(z < args.length){
	    	System.out.print(" " + args[z]);
	    	z++;
	    }
	    System.out.println(":");
	    
	    
	    //Rechecking args[0] for alarm terms
	    ReMessage = new Scanner(new File(args[0]));
	    while(ReMessage.hasNext()){
			StringTokenizer words = new StringTokenizer(ReMessage.nextLine().toLowerCase());
			
			//Checks if tokens in args[0] are within alarm BST
		    while (words.hasMoreTokens()) {
		    	String tok = words.nextToken();
		    	alarm.find(tok);
		    }
	    }
	    
	    //Print alarm-flagged terms specifically
	    System.out.println("these words were found:");
	    alarm.printAlarms(alarm.root);
	}
		
    //method to swap 2 characters within a string
	public static String spellCheck(String word, int i, int j)
	{
		//If index is out of bounds for the char array, return specific String
	    if( i < 0 || i >= word.length() || j < 0 || j >= word.length()) return "Word Not Found";

	    //Swap two characters in char array made from the word you want to spellCheck, then return as a string
	    char string[] = word.toCharArray();
	    char temp = string[i];
	    string[i] = string[j];
	    string[j] = temp;

	    return new String(string);
	}
	
	
}
