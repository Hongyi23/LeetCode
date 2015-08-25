package c8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SubsetIISolution{
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		LinkedList<Integer> result = new LinkedList<>();
        List<List<Integer>> solution = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return solution;
        
        insertion_sort(nums);
        
        dfs(nums, 0, result, solution);
        return solution;
        
    }
	
	private void dfs(int[] nums, int start, LinkedList<Integer> result, List<List<Integer>> solution){
		{//这道题并不是一定要达到最深才能输出结果 所以此处只要递进一层 就加一个结果
			ArrayList<Integer> temp = new ArrayList<>();     //记住 一定要用temp 因为result值的变化会影响solution中的值 所以必须创造一个新的list存放结果
			Iterator<Integer> iter = result.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			solution.add(temp);
		}

		for(int i = start; i < nums.length; i++){
//			if(visited[i]) continue;
			if(i != start && nums[i - 1] == nums[i]) continue;
			
			result.add(nums[i]);
//			visited[i] = true;
			dfs(nums, i + 1, result, solution);
			result.pollLast();
//			visited[i] = false;
		}
	}
	
	private void insertion_sort(int input[]){      //从前向后版本
		for(int i = 1; i < input.length; i++){
			int val = input[i];
			for(int j = 0; j < i; j++){
				if(input[j] > val){
					System.arraycopy(input, j, input, j + 1, i - j);
					input[j] = val;
					break;
				}
			}
		}
	}
}

public class SubsetII {
	public static void main(String[] args) {
		int[] input = {1, 2, 2};
		System.out.println(new SubsetIISolution().subsetsWithDup(input));

	}
	

}
