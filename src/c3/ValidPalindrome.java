package c3;

class Solution_31 {
    public boolean isPalindrome(String s) {
        char[] buffer = unite(s).toCharArray();
        int start = 0, end = buffer.length - 1;
        while(start < end){
        	if(buffer[start++] != buffer[end--]) return false;
        }
        return true;
    }
    
    private String unite(String str){
    	StringBuilder sb = new StringBuilder();
    	for(char c : str.toCharArray()){
    		if(Character.isLetterOrDigit(c)){
    			sb.append(Character.toLowerCase(c));
    		}
    	}
    	return sb.toString();
    }
}

public class ValidPalindrome {

	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama";
		System.out.println(new Solution_31().isPalindrome(input));

	}

}
