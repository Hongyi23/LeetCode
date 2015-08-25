package c8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SubsetSolution{
	public List<List<Integer>> subsets(int[] nums) {
		LinkedList<Integer> result = new LinkedList<>();
        List<List<Integer>> solution = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return solution;
        
        insertion_sort(nums);
        
        dfs_v2(nums, 0, result, solution);
        return solution;
        
    }
	
	private void dfs(int[] nums, int step, LinkedList<Integer> result, List<List<Integer>> solution){
		if(step == nums.length){
			ArrayList<Integer> temp = new ArrayList<>();     //记住 一定要用temp 因为result值的变化会影响solution中的值 所以必须创造一个新的list存放结果
			Iterator<Integer> iter = result.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			solution.add(temp);
			return;
		}
		// not choose
		dfs(nums, step + 1, result, solution);
		// choose it
		result.add(nums[step]);
		dfs(nums, step + 1, result, solution);
		result.pollLast();
	}
	
	private void dfs_v2(int[] nums, int start, LinkedList<Integer> result, List<List<Integer>> solution){
		{//这道题并不是一定要达到最深才能输出结果 所以此处只要递进一层 就加一个结果
			ArrayList<Integer> temp = new ArrayList<>();     //记住 一定要用temp 因为result值的变化会影响solution中的值 所以必须创造一个新的list存放结果
			Iterator<Integer> iter = result.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			solution.add(temp);
		}
		//不用判重 因为i start from start 所以不会有重复
		for(int i = start; i < nums.length; i++){
			
			result.add(nums[i]);
			dfs_v2(nums, i + 1, result, solution);
			result.pollLast();
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

public class Subset {

	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		System.out.println(new SubsetSolution().subsets(input));

	}

}
