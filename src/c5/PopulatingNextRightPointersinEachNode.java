package c5;

import java.util.Iterator;
import java.util.LinkedList;

class Solution_5112 {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        LinkedList<TreeLinkNode> cur = new LinkedList<>();
        LinkedList<TreeLinkNode> next = new LinkedList<>();
        
        cur.push(root);
        
        while(!cur.isEmpty()){
        	if(cur.size() > 1){
        		for(int i = 0; i < cur.size() - 1; i++){
            		cur.get(i).next = cur.get(i + 1);
            	}
        	}
        	cur.get(cur.size() - 1).next = null;
        	while(!cur.isEmpty()){
        		TreeLinkNode tmp = cur.poll();
        		
        		if(tmp.left != null) next.addLast(tmp.left);
        		if(tmp.right != null) next.addLast(tmp.right);
        	}
        	//swap
        	Iterator<TreeLinkNode> iter = next.iterator();
        	while(iter.hasNext()){
        		cur.add(iter.next());
        	}
        	next.clear();
        }
    }
}

public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		TreeLinkNode root = new CreateTree().createLink();
		new Solution_5112().connect(root);
		int k = 0;
	}
}
