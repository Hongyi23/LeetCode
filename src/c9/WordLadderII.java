package c9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class solution_91{
	
	public String start, end;
	public Set<String> dict;
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		
		this.start = start;
		this.end = end;
		this.dict = dict;
		
		LinkedList<String> current = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		HashMap<String, ArrayList<String>> father;

		boolean found = false;
		
		current.add(start);
		while(!current.isEmpty() && !found){
			for(String s : current){
				visited.add(s);
			}
			
			String str = current.poll();
				
			ArrayList<String> new_states = state_extend(str, visited);
			if(new_states != null){
				for(String s : new_states){
					next.add(s);
					if(isTarget(s)){
						found = true;
						break;
					}
				}
			}
			LinkedList<String> temp = new LinkedList<>();
			temp = current;
			current = next;
			next = temp;
		}
		
		if(found) return level + 1;
		else return 0;
	}
	
	public ArrayList<String> state_extend(String s, HashSet<String> visited){
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++){
			String s_copy = s;
			for(char c = 'a'; c <= 'z'; c++){
				if(c == s.charAt(i)) continue;
				
				char[] s_char = s.toCharArray();
				s_char[i] = c;
				s = new String(s_char);
				
				if((!visited.contains(s) && this.dict.contains(s)) || s.equals(this.end)){  //判断string相等一定不能用== 要用equals
					result.add(s);
					visited.add(s);
				}
				
				s = s_copy;
			}
		}
		
		return result;
	}
	
	private boolean isTarget(String s){
		return s.equals(this.end);
	}
}

public class WordLadderII {

}
