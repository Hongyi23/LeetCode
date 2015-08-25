package c3;

class Solution_32 {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = 0; i <=haystack.length() - needle.length(); i++){
        	for(j = 0; j < needle.length(); j++){
        		if(needle.charAt(j) != haystack.charAt(i + j)) break;
        	}
        	if(j == needle.length()) return i;
        }
        return -1;
    }
}

public class StrStr {
	public static void main(String[] args) {
		String a = "abcabc", b = "ca";
		System.out.println(new Solution_32().strStr(a, b));
	}
}
