package c1;

import java.util.HashMap;

class Solution_216 {
    public int longestConsecutive(int[] nums){
    	HashMap<Integer, Boolean> used = new HashMap<>();
    	
    	for(int i : nums) used.put(i, false);
    	
    	int longest = 0;
    	
    	for(int i : nums){
    		if(used.get(i)) continue;
    		
    		int length = 1;
    		
    		used.put(i, true);
    		
    		for(int j = i + 1; used.containsKey(j); j++){
    			used.put(j, true);
    			length++;
    		}
    		
    		for(int j = i - 1; used.containsKey(j); j++){
    			used.put(j, true);
    			length++;
    		}
    		
    		longest = (length > longest)? length : longest;
    	}
    	
    	return longest;
    }
}

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new Solution_216().longestConsecutive(nums));
	}

}
