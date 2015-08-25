package c5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution_516 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        boolean reverse = false;
        
        TreeNode p = root;
        if(p == null) return result;
        
        cur.push(p);
        while(!cur.isEmpty()){
        	while(!cur.isEmpty()){
        		p = cur.pollLast();
        		level.add(p.val);
        		
        		if(p.left != null) next.push(p.left);
        		if(p.right != null) next.push(p.right);
        	}
        	// add to result
        	List<Integer> tmp = new ArrayList<>();
        	Iterator<Integer> level_iter = level.iterator();
        	while(level_iter.hasNext()){
        		if(reverse) tmp.add(0, level_iter.next());
        		else tmp.add(level_iter.next());
        	}
        	result.add(tmp);
        	level.clear();
        	// swap cur and next
        	Iterator<TreeNode> iter = next.iterator();
        	while(iter.hasNext()){
        		cur.add(iter.next());
        	}
        	next.clear();
        	reverse = !reverse;
        }
        
        return result;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		System.out.println(new Solution_516().zigzagLevelOrder(new CreateTree().create()));

	}

}
