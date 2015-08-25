package c4;

import java.util.Stack;

class Solution_44 {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        for(String s : tokens){
        	if(!isOperator(s)){
        		stk.push(s);
        	}else{
        		int x = Integer.parseInt(stk.pop());
        		int y = Integer.parseInt(stk.pop());
        		if(s.equals("+")) x += y;
        		else if(s.equals("-")) x -= y;
        		else if(s.equals("*")) x *= y;
        		else x /= y;
        		stk.push(String.valueOf(x));
        	}
        }
        return Integer.parseInt(stk.peek());
    }
    
    private boolean isOperator(String s){
    	return s.length() == 1 && "+-*/".indexOf(s.charAt(0)) != -1;
    }
}

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] inputStrings = {"2", "1", "+", "3", "*"};
		System.out.println(new Solution_44().evalRPN(inputStrings));

	}

}
