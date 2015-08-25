package c5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution_511 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode p = root;
        Stack<TreeNode> stk = new Stack<>();
        
        stk.push(p);
        
        while(!stk.isEmpty()){
        	p = stk.pop();
        	result.add(p.val);
        	
        	if(p.right != null) stk.push(p.right);    //为了保证是先序 要先压右再压左
        	if(p.left != null) stk.push(p.left);
        }
        return result;
    }
}

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		System.out.println(new Solution_511().preorderTraversal(new CreateTree().create()));

	}

}
