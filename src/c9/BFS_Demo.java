package c9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

class mapNode{
	private int data;
	private ArrayList<mapNode> children;
	public mapNode(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setChildren(ArrayList<mapNode> children){
		this.children = children;
	}
	public int getData(){
		return this.data;
	}
	public ArrayList<mapNode> getChildren(){
		return this.children;
	}
}

class mapDeom{	
	public mapNode create(){
		mapNode a = new mapNode(4);
		mapNode b = new mapNode(3);
		mapNode c = new mapNode(1);
		mapNode d = new mapNode(2);
		mapNode e = new mapNode(5);
		mapNode f = new mapNode(6);
		
		ArrayList<mapNode> a_children = new ArrayList<mapNode>();
		a_children.add(b);
		a_children.add(c);
		a.setChildren(a_children);
		
		ArrayList<mapNode> b_children = new ArrayList<mapNode>();
		b_children.add(d);
		b_children.add(e);
		b_children.add(f);
		b.setChildren(b_children);
		
		return a;
	}
	
	public void bfs_traverse_double_queue(mapNode root){
		LinkedList<mapNode> next = new LinkedList<>();
		LinkedList<mapNode> current = new LinkedList<>();
		HashSet<mapNode> visited = new HashSet<>();
		
		int level = 0;
		
		current.push(root);
		visited.add(root);
		while(!current.isEmpty()){
			level++;
			while(!current.isEmpty()){
				mapNode cur = current.poll();
				System.out.println(cur.getData());
				ArrayList<mapNode> chl = cur.getChildren();
				if(chl != null){
					for(mapNode node : chl){
						next.add(node);
					}
				}
			}
			LinkedList<mapNode> temp = new LinkedList<>();
			temp = current;
			current = next;
			next = temp;
		}
		System.out.println('\n' + "level: " + level);
	}
	
	public void bfs_traverse_single_queue(mapNode root){
		LinkedList<mapNode> q = new LinkedList<>();
		int level = 0;
		
		q.push(root);
		while(!q.isEmpty()){
			mapNode cur = q.poll();
			System.out.println(cur.getData());
			ArrayList<mapNode> chl = cur.getChildren();
			if(chl != null){     //需要判断有没有children
				for(mapNode node:chl){
					q.add(node);
				}
			}
		}
	}
}

public class BFS_Demo {

	public static void main(String[] args) {
		mapDeom newMap = new mapDeom();
//		newMap.bfs_traverse_double_queue(newMap.create());
		newMap.bfs_traverse_single_queue(newMap.create());
	}

}
