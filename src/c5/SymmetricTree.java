package c5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution_519 {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> level = new LinkedList<>();
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        
        TreeNode p = root;
        if(p == null) return true;
        
        cur.push(p.left);
        cur.push(p.right);
        
        while(!cur.isEmpty()){        	
        	Iterator<TreeNode> level_iter = cur.iterator();
        	boolean isAllNull = true;
        	for(int i = 0; i < cur.size(); i++){
        		if(level_iter.next() != null){
        			isAllNull = false;
        			break;
        		}
        	}
        	if(isAllNull) return true;       	
        	while(!cur.isEmpty()){
        		p = cur.pollLast();
        		level.add(p);
        		
        		if(p == null){
        			next.push(null);
        			next.push(null);
        		}else{
        			if(p.left != null) next.push(p.left);
            		else next.push(null);
            		if(p.right != null) next.push(p.right);
            		else next.push(null);
        		}        		
        	}      	
        	//check if it's OK in level;
        	while(!level.isEmpty()){
        		TreeNode a = level.pollFirst();
            	TreeNode b = level.pollLast();
            	if(a == null && b == null) continue;
            	else if(a == null || b == null) return false;
            	else if(a.val != b.val) return false;
        	}
        	
        	Iterator<TreeNode> iter = next.iterator();
        	while(iter.hasNext()){
        		cur.add(iter.next());
        	}
        	next.clear();
        }
        return true;
    }
    
    public boolean isSymmetric1(TreeNode root){
    	if(root == null) return true;
    	
    	return isSame(root.left, root.right);
    }
    
    private boolean isSame(TreeNode left, TreeNode right){
    	if(left == null && right == null) return true;
    	if(left == null || right == null) return false;
    	if(left.val != right.val) return false;
    	
    	return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}

public class SymmetricTree {

	public static void main(String[] args) {
		System.out.println(new Solution_519().isSymmetric1(new CreateTree().create()));

	}

}
