package c1;

class solution_12{
	
	public int dup;
	
	public solution_12(int dup){
		this.dup = dup;
	}
	
	public int removeDuplicates(int[] nums){
		if(nums == null || nums.length <= this.dup + 1) return nums.length;
		
		int index = this.dup + 1;
		for(int i = index; i < nums.length; i++){
			if(nums[i] != nums[index - this.dup - 1]){
				nums[index] = nums[i];
				index++;
			}
		}
		
		for(int i = 0; i < index; i++){
			System.out.print(nums[i]);
			System.out.print(", ");
		}
		System.out.println();
		
		return index;
	}
}

public class DeleteDup {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3};
		new solution_12(1).removeDuplicates(nums);

	}

}
