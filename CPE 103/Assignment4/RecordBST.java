///-----------------------------------------------------------------
///   Class:          <RecordBST>
///   Description:    <Creates ItemRecord BST for use with CheckMessage program>
///   Author:         <Michael Elliott>
///   Instructor:     <Dr. Buckalew>
///   Course:         <CPE 103-11>
///   Date:           <11/28/16>
///-----------------------------------------------------------------

public class RecordBST {
	
	public Node root;
	
	private class Node{
		@SuppressWarnings("rawtypes")
		ItemRecord data;
		Node left;
		Node right;	
		
		//Constructs Node with data type ItemRecord, as well as a pointer to left/right nodes
		@SuppressWarnings("rawtypes")
		public Node(String data){
			this.data = new ItemRecord(data);
			left = null;
			right = null;
		}
	}
	
	//Constructs BST with input String as root
	public RecordBST(String x){
		root = new Node(x);
	}
	
	//Overload method for null BST
	public RecordBST(){
		root = null;
	}

	//inserts String into BST (after creating an ItemRecord object with said String)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(String x){
		
		if (root == null){
			root = new Node(x.toLowerCase());
		}
		
		else{
			Node p = root;
			while (p!= null){
				if(p.data.compareTo(new ItemRecord(x)) > 0){
					if(p.left != null){
						p = p.left;
					}
					else{
						p.left = new Node(x);
						break;
					}
				}
				else{
					if(p.right != null){
						p = p.right;
					}
					else{
						p.right = new Node(x);
						break;
					}
				}
			}
		}
		return;
	}
	
	//Finds terms and flags them when found (does this for spellCheck as well, however use of these flags are optional and not implemented)
	public boolean find(String x){
		Node p = root;
		while(p != null){
			if(p.data.compareTo(new ItemRecord(x)) == 0){
				p.data.flag = true;
				return true;
			}
			else if(p.data.compareTo(new ItemRecord(x)) > 0){
				p = p.left;
			}
			else{
				p = p.right;
			}
		}
		return false;
	}
	
	//Only prints terms in BST that have been flagged
	public void printAlarms(Node p){
		if(p!= null){
			printAlarms(p.left);
			if(p.data.flag == true) System.out.println(p.data.token);
			printAlarms(p.right);
		}
	}
}
