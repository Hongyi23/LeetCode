package c12;

import java.util.HashMap;

class Solution_125 {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> visited = new HashMap<>();
        
        int length = 0;
        int current_length = 0;
        int start = 0;

        for(int i = 0; i < c.length;){
        	if(visited.containsKey(c[i])){
        		current_length = i - start;
        		length = (length > current_length)? length : current_length;
        		start = visited.get(c[i]) + 1;
        		visited.clear();
        		i = start;
        		current_length = 0;
        	}
        	else{
        		visited.put(c[i], i);
        		current_length++;
        		i++;
        	}
        }
        
        return (current_length > length)? current_length : length;
    }
}

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(new Solution_125().lengthOfLongestSubstring("qpxrjxkltzyx"));

	}

}
