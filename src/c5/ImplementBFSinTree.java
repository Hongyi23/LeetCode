package c5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BFS{
	public List<Integer> BFStree(TreeNode root){
		List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode p = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.addLast(p);
        while(!queue.isEmpty()){
        	p = queue.pollFirst();
        	result.add(p.val);
        	
        	if(p.left != null) queue.addLast(p.left);
        	if(p.right != null) queue.addLast(p.right);
        }
        
        return result;
	}
}

public class ImplementBFSinTree {

	public static void main(String[] args) {
		System.out.println(new BFS().BFStree(new CreateTree().create()));

	}

}
