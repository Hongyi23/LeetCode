package c4;

import java.util.Stack;

class Solution_41 {
    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";
        Stack<Character> stk = new Stack<>();
        
        for(char c : s.toCharArray()){
        	if(left.indexOf(c) != -1) stk.push(c);
        	else{
        		if(stk.isEmpty() || stk.peek() != left.charAt(right.indexOf(c))) return false;
        		else stk.pop();
        	}
        }
        
        return stk.isEmpty();
    }

//    public boolean isValid2(String s){
//    	char[] input = s.toCharArray();
//    	
//    }
}

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
