package c5;

class Solution_541 {
    public int minDepth(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 1;
        
        int left = 0, right = 0;
        if(root.left != null) left = minDepth(root.left) + 1;
        else left = Integer.MAX_VALUE;
        if(root.right != null) right = minDepth(root.right) + 1;
        else right = Integer.MAX_VALUE;
        
        return Math.min(left, right);
    }
}

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		System.out.println(new Solution_541().minDepth(new CreateTree().create()));
	}

}
