package c5;

public class CreateTree {
	public TreeNode create(){
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(6);
		
		root.left = left;
//		root.right = right;
		
//		left.left = new TreeNode(1);
//		left.right = new TreeNode(3);
//		
//		right.left = new TreeNode(8);
//		right.right = new TreeNode(7);
		
		return root;
	}
	
	public TreeLinkNode createLink(){
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		
		root.left = left;
		root.right = right;
		
		left.left = new TreeLinkNode(4);
		left.right = new TreeLinkNode(5);
		
//		right.left = new TreeLinkNode(4);
		right.right = new TreeLinkNode(6);
		
		return root;
	}
}
