package c5;

class Solution_5111 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left == null) return;     //处理好right之后 如果没有left 则直接return
        
        TreeNode p = root.left;
        while(p.right != null) p = p.right;
        p.right = root.right;
        root.right = p;
        root.left = null;
    }
}

public class FlattenBinaryTreetoLinkedList {
	public static void main(String[] args) {


	}
}
