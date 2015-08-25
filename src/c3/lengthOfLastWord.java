package c3;

class Solution_315 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        
        
        char[] input = s.toCharArray();
        int count = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
        	if(input[i] == ' '){
        		if(input[i + 1] != ' ') count = 0;
        	}else count++;
        }
        
        if(input[s.length() - 1] == ' '){
        	if(input[s.length() - 2] == ' ') return count;
        	else return count;
        }else{
        	if(input[s.length() - 2] == ' ') return count;
        	else return count;
        }
    }
    
    public int lengthOfLastWord2(String s){
    	s = s.trim();
    	for(int i = s.length() - 1; i >= 0; i--){
    		if(s.charAt(i) == ' ') return s.length() - 1 - i;
    	}
    	return s.length();
    }
}

public class lengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(new Solution_315().lengthOfLastWord2("hello world"));

	}

}
