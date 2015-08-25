package c8;
import java.util.*;

class PhoneSolution{
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(digits, 0, "", result);
        return result;
    }
	
	private String[] keyboard = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	private void dfs(String digits, int step, String path, List<String> result){
		if(step == digits.length()){
			result.add(path);
			return;
		}
		for(char c : keyboard[digits.charAt(step) - '0'].toCharArray()){
			dfs(digits, step + 1, path + c, result);
		}
	}
}

public class Phone {

	public static void main(String[] args) {
		System.out.println(new PhoneSolution().letterCombinations("27"));

	}

}
