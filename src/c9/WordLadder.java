//判断string相等一定不能用== 要用equals

//

package c9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class solution_91{
	
	public String start, end;
	public Set<String> dict;
	
	public int ladderLength(String start, String end, Set<String> dict){
		
		this.start = start;
		this.end = end;
		this.dict = dict;
		
		LinkedList<String> current = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		
		int level = 0;
		boolean found = false;
		
		current.add(start);
		while(!current.isEmpty() && !found){
			level++;
			while(!current.isEmpty() && !found){
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

public class WordLadder {
	public static void main(String args[]){
		Set<String> dict = new HashSet<String>();
		dict.add("hot");dict.add("dot");dict.add("dog");dict.add("lot");dict.add("log");
		String start = new String("hit");
		String end = new String("cog");
		
		solution_91 sol = new solution_91();
		System.out.println(sol.ladderLength(start, end, dict));
	}
}
