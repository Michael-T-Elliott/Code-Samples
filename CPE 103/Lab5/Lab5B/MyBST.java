
public class MyBST extends BST{

	public boolean isBalanced(){
		Node p = root;
		while(p != null){
			if(height(p.left) - height(p.right) > 1){
 				return false;
			}
			else if (height(p.left) - height(p.right) < -1){
				return false;
			}
			p = p.left;
		}

		p = root;
		while(p != null){
			if(height(p.left) - height(p.right) > 1){
 				return false;
			}
			else if (height(p.left) - height(p.right) < -1){
				return false;
			}
			p = p.right;
		}
		return true;
	}

	public int height(){
		return height(root);
	}

	private int height(Node p){
		if(p == null){
			return 0;
		}

		return 1 + Math.max(height(p.left), height(p.right));
	}
}
