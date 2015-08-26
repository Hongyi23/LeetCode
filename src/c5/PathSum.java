package c5;

class Solution_543 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        return dfs(root, sum, root.val);
    }
    
    private boolean dfs(TreeNode root, int sum, int my_sum){
    	if((root.left == null && root.right == null) && my_sum == sum) return true;
    	
    	if(root.left != null){
    		if(dfs(root.left, sum, my_sum + root.left.val)) return true;
    	}
    	if(root.right != null){
    		if(dfs(root.right, sum, my_sum + root.right.val)) return true;
    	}
    	
    	return false;
    }
}

public class PathSum {

	public static void main(String[] args) {
		System.out.println(new Solution_543().hasPathSum(new CreateTree().create(), 15));

	}

}
