package c5;

class Solution_5111 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left == null) return;     //�����right֮�� ���û��left ��ֱ��return
        
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
