package c3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import sun.tools.jar.resources.jar;

class Solution_313 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] tmpString = new String[strs.length];
        List<List<String>> result = new ArrayList<>();
        
        if(strs == null || strs.length == 0) return result;
        
        for(int i = 0; i < strs.length; i++){
        	char[] tmp = strs[i].toCharArray();
        	Arrays.sort(tmp);
        	tmpString[i] = new String(tmp);
        }
        boolean[] used = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
        	if(used[i]) continue;
        	used[i] = true;
        	List<String> solution = new ArrayList<>();
        	solution.add(strs[i]);
        	for(int j = i + 1; j < strs.length; j++){
        		if(tmpString[i].equals(tmpString[j])){
        			used[j] = true;
        			solution.add(strs[j]);
        		}
        	}
        	result.add(solution);
        }
        
        return result;
    }
    
    public List<List<String>> groupAnagrams1(String[] strs){
    	HashMap<String, List<String>> mapping = new HashMap<>();
    	List<List<String>> result = new ArrayList<>();
    	
    	for(int i = 0; i < strs.length; i++){
    		char[] tmp = strs[i].toCharArray();
    		Arrays.sort(tmp);
    		if(mapping.containsKey(new String(tmp))){
    			mapping.get(new String(tmp)).add(strs[i]);
    		}else{
    			List<String> val_str = new ArrayList<>();
    			val_str.add(strs[i]);
    			mapping.put(new String(tmp), val_str);
    		}
    	}
    	Iterator<List<String>> iter = mapping.values().iterator();
    	while(iter.hasNext()){
    		result.add(iter.next());
    	}
    	
    	return result;
    }
}

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(new Solution_313().groupAnagrams1(input));

	}

}
