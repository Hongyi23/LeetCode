package c6;

public class ProductofArrayExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        for(int k = 0; k < answer.length; k++){
            answer[k] = 1;
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(j != i){
                    answer[i] = answer[i] * nums[j];
                }
            }
        }
        
        return answer;
    }
	

	public static void main(String[] args) {
		
		int[] input = {2,3,4,6};
		
		int[]answer = productExceptSelf(input);
		
		for(int a : answer){
			System.out.println(a);
		}

	}

}
