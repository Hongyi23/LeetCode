package c3;

class Solution_39 {
    public boolean isNumber(String s) {
    	
    	if(s == null || s.length() == 0) return false;
    	
    	boolean point_flag = true, e_flag = true;
        char[] input = s.toCharArray();
        int i = 0;
        
        while(i < input.length && input[i] == ' ') i++;
        if(i == input.length) return false;
        
        //first element which is not ' '
        if(input[i] == '.'){
        	i++;
        	point_flag = false;
        }
        else if((input[i] != '-') && (!Character.isDigit(input[i]))) return false;
        
        i++;
        
        while(i < s.length()){
        	if(Character.isDigit(input[i]) || input[i] == ' ') i++;
        	else if(input[i] == '.' && point_flag){
        		i++;
        		point_flag = false;
        	}else if(input[i] == 'e' && e_flag){
        		i++;
        		e_flag = false;
        	}
        	else return false;
        }
        
        return true;
    }
}

public class ValidNumber {

	public static void main(String[] args) {
		System.out.println(new Solution_39().isNumber(".1.1"));

	}

}
