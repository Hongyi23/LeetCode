package c3;

import java.util.Arrays;

class Solution_312 {
    public String countAndSay(int n) {
        String tmp = "1";
        for(int i = 1; i < n; i++){
        	StringBuilder result = new StringBuilder();
        	for(int j = 0; j < tmp.length();){
        		int count = 0;
        		while((j + count < tmp.length()) && tmp.charAt(j + count) == tmp.charAt(j)){
        			count++;
        		}
        		result.append(count);
        		result.append(tmp.charAt(j));
        		j = j + count;
        	}
        	tmp = result.toString();
        }
        return tmp;
    }
}

public class CountandSay {

	public static void main(String[] args) {
		System.out.println(new Solution_312().countAndSay(3));
		String lalala = "bcadqd";
		char[] in = lalala.toCharArray();
		Arrays.sort(in);
		System.out.println(in);

	}

}
