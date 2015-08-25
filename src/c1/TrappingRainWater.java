package c1;

class solution_2115{
	public int trap(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        
        for(int i = 1; i < height.length; i++){
        	max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        	max_right[height.length - 1 - i] = Math.max(max_right[height.length - i], height[height.length - i]);
        }
        
        int sum = 0;
        
        for(int i = 1; i < height.length - 1; i++){
        	int high = Math.min(max_left[i], max_right[i]);
        	if(high > height[i]){
        		sum = sum + high - height[i];
        	}
        }
        
        return sum;
        
        Math.
    }
}

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new solution_2115().trap(input));

	}

}
