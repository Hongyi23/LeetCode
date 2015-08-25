package c1;

import java.util.LinkedList;

class PermutationsSequenceSolution{
	public String getPermutation(int n, int k) {
        String result = new String();
        this.result = new String();
        this.found = false;
        this.no = 0;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        if(n == 0 || k == 0) return result;
        
        dfs_1(n, k, 0, visited, path);
        return this.result;
    }
	
	private String result;
	private boolean found;
	private int no;
	
	private void dfs_1(int n, int k, int step, boolean[] visited, LinkedList<Integer> path){
		if(step == n){
			this.no++;
			if(k == this.no){
				this.result = path.toString();
				this.found = true;
			}
			return;
		}
		
		for(int i = 1; i <= n; i++){
			if(visited[i]) continue;
			
			visited[i] = true;
			path.add(i);
			
			dfs_1(n, k, step + 1, visited, path);
			
			if(this.found) return;
			
			visited[i] = false;
			path.pollLast();
		}
	}
}

public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println(new PermutationsSequenceSolution().getPermutation(8, 16000));

	}

}
