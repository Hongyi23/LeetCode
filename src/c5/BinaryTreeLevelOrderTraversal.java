package c5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import c1.ListNode;

class Solution_514 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        
        TreeNode p = root;
        if(p == null) return result;
        
        cur.push(p);
        while(!cur.isEmpty()){
        	while(!cur.isEmpty()){
        		p = cur.pollLast();
        		level.add(p.val);
        		
        		if(p.left != null) next.push(p.left);
        		if(p.right != null) next.push(p.right);
        	}
        	// add to result
        	List<Integer> tmp = new ArrayList<>();
        	Iterator<Integer> level_iter = level.iterator();
        	while(level_iter.hasNext()){
        		tmp.add(level_iter.next());
        	}
        	result.add(tmp);    //���ֱ�Ӱ�level��ֵ��result ֮��level.clear֮��result��Ҳ�ᱻ��� ����Ҫ��һ��tmp
        	level.clear();
        	// swap cur and next
        	Iterator<TreeNode> iter = next.iterator();
        	while(iter.hasNext()){
        		cur.add(iter.next());
        	}
        	next.clear();
//        	cur = next;    //����ֱ�Ӹ�ֵҲ����ս�� ����Ҫһ��һ��add
//        	next.clear();
        }
        
//        List<List<Integer>> temp = new ArrayList<>();
//        Iterator<List<Integer>> it = result.iterator();
//        while(it.hasNext()){
//        	temp.add(0, it.next());
//        }
//        return temp;
        return result;
    }
}

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		System.out.println(new Solution_514().levelOrder(new CreateTree().create()));

	}

}
