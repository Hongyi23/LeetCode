package c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class TwoSums{
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> mapping = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++){
			mapping.put(nums[i], i);
		}
		
		int[] result = new int[2];

		for(int i = 0; i < nums.length; i++){
			int gap = target - nums[i];
			
			mapping.remove(nums[i]);
			
			if(mapping.containsKey(gap)){
				int a = i, b = mapping.get(gap);
				if(a > b){
					result[0] = b + 1;
					result[1] = a + 1;
				}else{
					result[0] = a + 1;
					result[1] = b + 1;
				}
				return result;
			}
			
			mapping.put(nums[i], i);
		}
		
		return result;
	}
	
}

class Three_Sum{
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length < 3) return result;
		Arrays.sort(nums);
		int target = 0;
		
		for(int i = 0; i < nums.length - 2; i++){
			int b = i + 1, c = nums.length - 1;
			while(b < c){
				if(nums[i] + nums[b] + nums[c] < target) b++;
				else if(nums[i] + nums[b] + nums[c] > target) c--;
				else{
					List<Integer> solution = new ArrayList<>();
					solution.add(nums[i]);
					solution.add(nums[b]);
					solution.add(nums[c]);
					if(!result.contains(solution)) result.add(solution);
					
					while(b < c && nums[b + 1] == nums[b]) b++;
					while(b < c && nums[c - 1] == nums[c]) c--;
					
					b++;
					c--;
				}			
			}
		}
		return result;
	}
}

class Three_Sum_Closest{
	public int threeSum(int[] nums, int target) {
		int result = 0;
		int min_gap = Integer.MAX_VALUE;
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 2; i++){
			int b = i + 1, c = nums.length - 1;
			while(b < c){
				int sum = nums[i] + nums[b] + nums[c];
				int gap = Math.abs(target - sum);
				
				if(gap < min_gap){
					result = sum;
					min_gap = gap;
				}
				
				if(sum < target) b++;
				else c--;
			}
		}
		return result;
	}
}

public class N_Sums {

	public static void main(String[] args) {
		int[] input = {-1, -1, 0, 1, 2, -1, -4, -1, 2, 2};
		System.out.println(new Three_Sum().threeSum(input));
		
		

	}

}
