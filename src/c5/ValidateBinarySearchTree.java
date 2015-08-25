package c5;

class Solution_533 {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        
        if((!isValidBST(root.left)) || (!isValidBST(root.right))) return false;
        
        if(root.left != null){
        	TreeNode p = root.left;
        	while(p.right != null) p = p.right;
        	if(root.val <= p.val) return false;
        }
        if(root.right != null){
        	TreeNode q = root.right;
        	while(q.left != null) q = q.left;
        	if(root.val >= q.val) return false;
        }
        
        return true;
    }
}

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		System.out.println(new Solution_533().isValidBST(new CreateTree().create()));
	}
}