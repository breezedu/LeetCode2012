import java.util.Stack;

/*********************
	 * 
	 * @author Jeff
	 * 
	 */
	public class BSTIterator {
		
		Stack<TreeNode> minStack = null;
		TreeNode node = null;
		
	    public BSTIterator(TreeNode root) {
	        node = root;
	        minStack = new Stack<>();
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	
	    	return !minStack.isEmpty() || node != null; 
	    	
	        
	    }

	    /** @return the next smallest number */
	    public int next() {
			
	    	while( node != null){
	    		minStack.push(node);
	    		node = node.left;
	    	}
	    	
	    	TreeNode nodeT = minStack.pop();
	    	node = nodeT.right; 
	        
	    	return nodeT.val;
	    	
	    }//end next() method; 
	}
