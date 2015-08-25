package c10;

import java.util.*;

class Solution_107 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {	
        insertion_sort_v1(candidates);
        LinkedList<Integer> solution = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0) return result;
        
        dfs(0, 0, solution, target, candidates, result);      
        return result;
    }
    
    private void dfs(int start, int sum, LinkedList<Integer> solution, int target, int[] candidates, List<List<Integer>> result){
    	if(sum == target){
    		List<Integer> temp = new LinkedList<>();         //当result加入solution之后 若对solution有修改 则会对应修改result中的值

    		Iterator<Integer> iter = solution.iterator();     //所以此处复制一个temp 再加入temp
    		while(iter.hasNext()){
    			temp.add(iter.next());
    		}
    		
    		result.add(temp);
    		return;
    	}
    	
    	int previous = -1;      //设置为-1 使第一个循环能通过
    	for(int i = start; i < candidates.length; i++){ 		
    		if(sum + candidates[i] > target) return;
    		if(candidates[i] == previous) continue;
    		
    		solution.add(candidates[i]);
    		sum += candidates[i];
    		previous = candidates[i];
    		
    		dfs(i, sum, solution, target, candidates, result);
    		
    		solution.pollLast();      //单单一个poll等于pollFirst 实际上这是用List实现stack
    		sum -= candidates[i];
    	}
    }
    
    private void insertion_sort_v1(int input[]){      //从前向后版本
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

public class CombinationSum {

	public static void main(String[] args) {
		
		int[] money = {1, 5, 10, 20, 100};
		int[] input = {10,1,2,7,6,1,5};
		List<List<Integer>> result = new Solution_107().combinationSum(money, 12);
		System.out.println(result);

	}

}
