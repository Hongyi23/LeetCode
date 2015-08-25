package c5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution_512 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        Stack<TreeNode> stk = new Stack<>();
        
        while(!stk.isEmpty() || p != null){
        	if(p != null){
        		stk.push(p);
        		p = p.left;
        	}else{
        		p = stk.pop();
        		result.add(p.val);
        		p = p.right;
        	}
        }
        return result;
    }
}

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		System.out.println(new Solution_512().inorderTraversal(new CreateTree().create()));

	}

}
