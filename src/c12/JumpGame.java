package c12;

class Solution {
    public int canJump(int[] nums) {
        
        if(nums == null || nums.length == 1) return 0;
        
        int reach = 0;
        int step = 0;
        for(int i = 0; i <= reach && reach < nums.length; i++){
            if(reach < i + nums[i]){
            	reach = i + nums[i];
            	step++;
            }
        }
        
        if(reach >= (nums.length - 1)) return step;
        return 0;
    }
}

public class JumpGame {

	public static void main(String[] args) {
		int[] a = {2, 3, 1, 1, 4};
		System.out.println(new Solution().canJump(a));

	}

}
