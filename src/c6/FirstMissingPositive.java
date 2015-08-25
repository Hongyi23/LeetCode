package c6;

public class FirstMissingPositive {
	
	public static int missingPositive(int[] input){
		
		if(input.length == 0) return 1;
		
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
		
		if(input[input.length - 1] < 0) return 1;
		
		int[] example = new int[input[input.length - 1]];
		for(int k = 0; k < input[input.length - 1]; k++){
			example[k] = k + 1;
		}

		int k = 0;
		boolean flag;

		for(; k < example.length; k++){
			flag = false;
			for(int j = 0; j < input.length; j++){
				if(input[j] == example[k]){
					flag = true;
					break;
				}
			}
			if(!flag) return example[k];
		}
		
		return input[input.length - 1] + 1;
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		System.out.println(missingPositive(input));
	}

}
