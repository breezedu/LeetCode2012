package leetcode2017;

import java.util.ArrayList;
import java.util.List;

public class No257_BinaryTreePath {
	
	
    public List<String> binaryTreePaths(TreeNode root) {
    	
List<String> routine = new ArrayList<String>();
        
        if(root == null) return routine;
        String s = root.val+"";
        routine.add(s);
        
        if(root.left == null && root.right ==null)
            return routine; 
        
        List<String> routineL = new ArrayList<String>();
        List<String> routineR = new ArrayList<String>();
        
        if(root.left != null)
            routineL = recurRoutine(routine, root.left);
        if(root.right != null)
            routineR = recurRoutine(routine, root.right);
        
        return mergeList(routineL, routineR);
    }
    
    private static List<String> mergeList(List<String> l1, List<String> l2) {
		// TODO Auto-generated method stub
    	
    	List<String> list = new ArrayList<String>();
    	list.addAll(l1);
    	list.addAll(l2);
		return list;
	}

	private static List<String> recurRoutine(List<String> routine, TreeNode node){
        
        if(node == null) return routine;
        List<String> newRout = new ArrayList<String>();
        
        for(int i=0; i<routine.size(); i++){
            String s = routine.get(i) + "->" + node.val;
            newRout.add(s);
        }
        
        if(node.left == null && node.right == null)
            return newRout;
        
        List<String> newRoutL = new ArrayList<String>();
        List<String> newRoutR = new ArrayList<String>();
        
        
        if(node.left != null)
            newRoutL = recurRoutine(newRout, node.left);
        if(node.right != null)
            newRoutR = recurRoutine(newRout, node.right);
        
        return mergeList(newRoutL, newRoutR);
    }

}
