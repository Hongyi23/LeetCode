package c10;

import java.util.ArrayList;
import java.util.List;

class Solution_109{
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n > 0) generate(n, "", 0, 0, result);
        return result;
	}
	
	private void generate(int n, String s, int l, int r, List<String> result){
		if(l == n){
			for(int i = 0; i < n - r; i++){
				s = s.concat(")");
			}
			result.add(s);
			return;
		}
		
		generate(n, s + '(', l + 1, r, result);
		if(l > r) generate(n, s + ')', l, r + 1, result);
		
	}
}

public class GenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(new Solution_109().generateParenthesis(3));

	}

}
