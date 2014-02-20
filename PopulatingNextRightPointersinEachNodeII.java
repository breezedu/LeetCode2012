package leetCode2012;

import java.util.ArrayList;

/*****************
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? 
 * Would your previous solution still work?
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *         /  \
 *        2    3
 *       / \    \
 *      4   5    7
 *      
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 *   
 * @author Frog
 *
 */

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}


public class PopulatingNextRightPointersinEachNodeII {
	
	
	public void connect(TreeLinkNode root) {
        
        if(root == null){
            return;
        }
        
        ArrayList<TreeLinkNode> AL1 = new ArrayList<TreeLinkNode>();
        AL1.add(root);
        
        connectNodesinAL(AL1);
        
    }
    
    
    private static void connectNodesinAL(ArrayList<TreeLinkNode> AL){
        
        if(AL.isEmpty()) return;
        
        ArrayList<TreeLinkNode> nextAL = new ArrayList<TreeLinkNode>();
        int Len = AL.size();
        
        if(Len==1){
            
            if(AL.get(0).left!=null)
                nextAL.add(AL.get(0).left);
            if(AL.get(0).right!=null)
                nextAL.add(AL.get(0).right);
                
        } else {
        
        	for(int i=0; i<Len-1; i++){
            
        		AL.get(i).next = AL.get(i+1);
            
        		if(AL.get(i).left!=null)
        			nextAL.add(AL.get(i).left);
        		if(AL.get(i).right!=null)
        			nextAL.add(AL.get(i).right);
            
        	}//end for i<len-1 loop;
        	
        	if(AL.get(Len-1).left!=null)
        		nextAL.add(AL.get(Len-1).left);
            
        	if(AL.get(Len-1).right!=null)
        		nextAL.add(AL.get(Len-1).right);
            
        }
        
        AL.clear();
        connectNodesinAL(nextAL);
        
    }

}
