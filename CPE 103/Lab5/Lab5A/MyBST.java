import java.util.Iterator;

public class MyBST extends BST {

	public Comparable parent(Comparable x){ //Returns the parent of x
		if(find(x)){
			Node p = root;
			Node temp = null;
			if(p.item.equals(x)){
				return null;
			}
			while(p != null){
				if(p.item.equals(x)) break;
				temp = p;
				if(p.item.compareTo(x) > 0){
					p = p.left;
				}
				else{
					p = p.right;
				}
			}
			return temp.item;
		}
		return null;
	}
 
	public Comparable predecessor(Comparable x){ //Returns the predecessor of x
		if(find(x)){
			return x;
		}
		return null;
	}

	public Comparable successor(Comparable x){ //Returns the successor of x
		if(find(x)){
			return x;
		}
		return null;
	}

	public boolean find(Comparable x){ //Finds x, returns false if not found
		Node p = root;
		while(p != null){
			if(p.item.equals(x)) return true;
			else if(p.item.compareTo(x) > 0){
				p = p.left;
			}
			else{
				p = p.right;
			}
		}
		return false;
	}			
}
