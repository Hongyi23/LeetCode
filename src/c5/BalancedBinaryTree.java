package c5;

class Solution_5110 {
    public boolean isBalanced(TreeNode root) {
//        if(root == null || (root.left == null && root.right == null)) return true;
//        
//        int height_of_left = 0, height_of_right = 0;
//        if(root.left != null) height_of_left = heightOfTree(root.left);
//        if(root.right != null) height_of_right = heightOfTree(root.right);
//        if(Math.abs(height_of_left - height_of_right) > 1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
    	
    	return height(root) != -1;
    }
    
    public int heightOfTree(TreeNode node){
    	if(node.left == null && node.right == null) return 1;
    	else if(node.left == null && node.right != null) return heightOfTree(node.right) + 1;
    	else if(node.left != null && node.right == null) return heightOfTree(node.left) + 1;
    	else return Math.max(heightOfTree(node.left), heightOfTree(node.right)) + 1;
    }
    
    private int height(TreeNode node){
    	if(node == null) return 0;
    	int left = height(node.left);
    	if(left == -1) return -1;
    	int right = height(node.right);
    	if(right == -1) return -1;
    	if(Math.abs(left - right) <= 1) return Math.max(left, right) + 1;
    	return -1;
    }
}

public class BalancedBinaryTree {

	public static void main(String[] args) {
		System.out.println(new Solution_5110().isBalanced(new CreateTree().create()));

	}

}
