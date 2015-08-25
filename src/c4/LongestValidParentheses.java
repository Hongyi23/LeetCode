package c4;

import java.util.Stack;

class Solution_42 {
    public int longestValidParentheses(String s) {
    	Stack<Integer> stk = new Stack<>();
    	int last = 0, max_len = 0;
        for(int i = 1; i <= s.length(); i++){
        	char c = s.charAt(i - 1);
        	if(c == '('){
        		stk.push(i);
        	}else{
        		if(stk.isEmpty()){
        			last = i;
        		}else{
        			stk.pop();
        			if(stk.isEmpty()){
        				max_len = Math.max(max_len, i - last);
        			}else{
        				max_len = Math.max(max_len, i - stk.peek());
        			}
        		}
        	}
        }
        return max_len;
    }
}

public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(new Solution_42().longestValidParentheses(")()())()()("));

	}

}
