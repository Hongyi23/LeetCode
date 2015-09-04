package c7;

class Solution_71 {
    public int[] searchRange(int[] nums, int target) {
        int first = 0, last = nums.length - 1;  
        int target_pos = 0;
        boolean found = false;
        
        int[] result = new int[2];
        result[0] = -1;
    	result[1] = -1;
    	if(nums == null || nums.length == 0) return result;
        
        while(first != last){        //当first == last的时候 会停在第一个大于等于target的数上
        	int mid = (first + last) / 2;
        	if(nums[mid] < target){
        		first = mid + 1;
        	}else if(nums[mid] > target){
        		last = mid;
        	}else{
        		target_pos = mid;
        		found = true;
        		break;
        	}
        }
        
        if(first == last && nums[first] == target){    //记住有这种fitst == last且找到的情况 一定要加以判断
        	found = true;
        	target_pos = first;
        }
        
        if(!found){        	
        	return result;
        }else{
        	int target_low = target_pos, target_high = target_pos;
        	while(target_low >= 0 && nums[target_low] == target) target_low--;
        	while(target_high < nums.length && nums[target_high] == target) target_high++;
        	result[0] = target_low + 1;
        	result[1] = target_high - 1;
        	return result;
        }
    }
}

public class SearchforaRange {

	public static void main(String[] args) {
		int[] input = {5, 7, 7, 8, 8, 10};
		for(int i : new Solution_71().searchRange(input, 4)){
			System.out.println(i);
		}
		

	}

}
