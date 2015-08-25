package c8;
import java.util.*;

class PermutationsSolution{
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        
        if(nums == null || nums.length == 0) return result;
        
        dfs(nums, 0, visited, path, result);
        return result;
    }
	
	private void dfs(int[] nums, int step, boolean[] visited, LinkedList<Integer> path, List<List<Integer>> result){
		if(step == nums.length){
			List<Integer> temp = new ArrayList<>();
			Iterator<Integer> iter = path.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			result.add(temp);
			return;
		}
		
		//从零开始 因为选过的元素之前可能还有待选元素 此时用visited判重
		for(int i = 0; i < nums.length; i++){
			if(visited[i]) continue;
			
			visited[i] = true;
			path.add(nums[i]);
			
			dfs(nums, step + 1, visited, path, result);
			
			visited[i] = false;
			path.pollLast();
		}
	}
}

public class Permutations {

	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		System.out.println(new PermutationsSolution().permute(input));
	}

}
