package c8;
import java.util.*;

class CombinationsSolution{
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        
        if(n == 0 || k == 0) return result;
        
        dfs(n, k, 1, 0, path, result);
        return result;
    }
	
	private void dfs(int n, int k, int start, int step, LinkedList<Integer> path, List<List<Integer>> result){
		if(step == k){
			List<Integer> temp = new ArrayList<>();
			Iterator<Integer> iter = path.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			result.add(temp);
			return;
		}
		
		for(int i = start; i <= n; i++){
			
			path.add(i);
			dfs(n, k, i + 1, step + 1, path, result);
			path.pollLast();
			
		}
	}
}

public class Combinations {

	public static void main(String[] args) {
		System.out.println(new CombinationsSolution().combine(4, 2));

	}

}
