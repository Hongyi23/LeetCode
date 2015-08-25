package c5;

class Solution_542 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        
        return Math.max(left, right);
    }
}

public class MaximumDepthofBinaryTree {
	public static void main(String[] args) {
		System.out.println(new Solution_542().maxDepth(new CreateTree().create()));

	}
}
