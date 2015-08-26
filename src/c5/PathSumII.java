package c5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution_544 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        
        if(root == null) return result;
        
        path.add(root.val);
        dfs(root, sum, root.val, path, result);
        
        return result;
    }
    
    private void dfs(TreeNode root, int sum, int my_sum, LinkedList<Integer> path, List<List<Integer>> result){
    	if(my_sum == sum && (root.left == null && root.right == null)){
    		List<Integer> tmp = new ArrayList<>();
    		Iterator<Integer> iter = path.iterator();
    		while(iter.hasNext()){
    			tmp.add(iter.next());
    		}
    		result.add(tmp);
    		return;
    	}
    	
    	if(root.left != null){
    		my_sum = my_sum + root.left.val;
    		path.add(root.left.val);
    		
    		dfs(root.left, sum, my_sum, path, result);
    		
    		my_sum = my_sum - root.left.val;
    		path.pollLast();
    	}
    	
    	if(root.right != null){
    		my_sum = my_sum + root.right.val;
    		path.add(root.right.val);
    		
    		dfs(root.right, sum, my_sum, path, result);
    		
    		my_sum = my_sum - root.right.val;
    		path.pollLast();
    	}
    }
}

public class PathSumII {

	public static void main(String[] args) {
		System.out.println(new Solution_544().pathSum(new CreateTree().create(), 15));

	}

}
