package c13;

class solution_132{
	public int maxSubArray(int[] nums) {
		
		if(nums == null || nums.length == 0) return 0;
		
        int result = Integer.MIN_VALUE;
        int[] f = new int[nums.length];
        result = f[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
        	f[i] = (f[i - 1] + nums[i] > nums[i])? f[i - 1] + nums[i] : nums[i];
        	result = (result > f[i])? result : f[i];
        }
        return result;
    }
}

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new solution_132().maxSubArray(nums));
	}
}
