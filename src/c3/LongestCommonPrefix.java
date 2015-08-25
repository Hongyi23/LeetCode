package c3;

class Solution_38 {
    public String longestCommonPrefix(String[] strs) {
    	
    	if(strs.length == 0 || strs[0] == null || strs[0].length() == 0) return null;
    	
    	StringBuilder result = new StringBuilder();
    	for(int i = 0; i < strs[0].length(); i++){
    		for(String s : strs){
    			if(i >= s.length() || s.charAt(i) != strs[0].charAt(i)){
    				return result.toString();
    			}
    		}
    		result.append(strs[0].charAt(i));
    	}
    	return result.toString();
    }
}

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] input = {"aa", "a"};
		System.out.println(new Solution_38().longestCommonPrefix(input));

	}

}
