package leetCode2012;

/***********
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical 
 * and the nodes have the same value.
 * 
 * @author Frog
 *
 */
public class SameTree {

	public static void main(String[] args){
		
		System.out.println("This is a SameTree program.");
		//1st, build two trees
		TreeNode root1 = new TreeNode((int)(Math.random()*10));
			System.out.println("root1: " + root1.val);
		TreeNode root2 = new TreeNode((int)(Math.random()*10));
			System.out.println("root2: " + root2.val);
			
		boolean identicalTrees = isSameTree(root1, root2);
		
		if(identicalTrees){
			System.out.println("We got two identical trees.");
		} else {
			System.out.println("They are different trees");
		}
		
	} //end main();

	private static boolean isSameTree(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if(root1==null && root2==null){
			return true;
			
		} else if(root1==null && root2!=null){
			return false;
			
		} else if(root1!=null && root2==null){
			return false;
			
		} else if (root1.val == root2.val){
			return (isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right));
			
		}
				
		return false;
	} //end isSameTree() method;
	
	
} //end everything in SameTree class;
