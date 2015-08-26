package c5;

class Solution_547 {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        this.sum = 0;

        dfs(root, root.val);
        return this.sum;
    }
    
    private int sum;
    
    private void dfs(TreeNode root, int path){
    	if(root.left == null && root.right == null){
    		this.sum = this.sum + path;
    		return;
    	}
    	
    	if(root.left != null) dfs(root.left, path * 10 + root.left.val);
    	if(root.right != null) dfs(root.right, path * 10 + root.right.val);
    }
    
    public int sumNumbers1(TreeNode root) {
        if(root == null) return 0;
        return dfs1(root, 0);
    }

    private int sumNumbers1(TreeNode root, int carryOver) {
        if(root == null) return 0;
        int newCarryOver = carryOver * 10 + root.val;
        if(root.left == null && root.right == null) return newCarryOver;
        return sumNumbers1(root.left, newCarryOver) + sumNumbers1(root.right, newCarryOver);
    }
    
    private int dfs1(TreeNode root, int sum){
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) return 10 * sum + root.val;
    	
    	return dfs1(root.left, sum * 10 + root.val) + dfs1(root.right, sum + 10 + root.val);
    }
}

public class SumRoottoLeafNumbers {
	public static void main(String[] args) {
		System.out.println(new Solution_547().sumNumbers(new CreateTree().create()));
	}
}
