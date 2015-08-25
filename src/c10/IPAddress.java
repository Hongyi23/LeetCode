package c10;

import java.util.ArrayList;
import java.util.List;

class Solution_106{
	public List<String> restoreIpAddresses(String s) {
		
		this.c = new int[3];
        this.result = new ArrayList<>();
        
        if(s.length() < 4 || s.length() > 12) return result;
        
        dfs(s, 0);
        return result;
        
    }
	
	private int[] c;
	private List<String> result;
	
	private void dfs(String s, int times){
		
		if(times == 3){		
			if(!check(s, this.c[2] + 1, s.length())) return;     //check from last '.' to the end
			
			char[] solution = new char[s.length() + 3];
			char[] origin = s.toCharArray();
			for(int i_solu = 0, i_ori = 0, num_of_time = 0, offset = 0; i_solu < solution.length; i_solu++){
				if(num_of_time < 3 && i_solu == this.c[num_of_time] + 1 + offset){
					solution[i_solu] = '.';
					num_of_time++;
					offset++;
				}else{
					solution[i_solu] = origin[i_ori++];
				}
			}	
			this.result.add(new String(solution));
			return;
		}
		
		if(times == 0){
			if(s.charAt(0) == '0'){
				c[times] = 0;
				dfs(s, times + 1);
			}else{
				for(int i = 0; i < 3; i++){
					if(i == 2){
						if(!check(s, 0, 3)) continue;
					}
					c[times] = i;
					dfs(s, times + 1);
				}
			}		
		}else{
			for(int i = c[times - 1] + 1; i < c[times - 1] + 5 && i < s.length() - 1; i++){

				if(!check(s, c[times - 1] + 1, i + 1)) continue;
				
				this.c[times] = i;
				dfs(s, times + 1);
				
				
			}
		}
		
	}
	
	private boolean check(String s, int begin, int end){
		char[] c_num = s.substring(begin, end).toCharArray();
		int num = 0;
		for(int j = 0; j < c_num.length; j++){
			num = num * 10 + (c_num[j] - '0');
		}
		if(num == 0){
			if(c_num.length == 1) return true;
			else return false;
		}else{
			if(c_num[0] != '0' && (num >= 0 && num <= 255)) return true;
			else return false;
		}
	}
}

class solution_leetcode{      //start表示下一段开始的地方 step
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		String ip = new String();
		dfs(s, 0, 0, ip, result);
		return result;
	}
	
	private void dfs(String s, int start, int step, String ip, List<String> result){
		if(start == s.length() && step == 4){
			ip = ip.substring(0, ip.length() - 1);
			result.add(ip);
			return;
		}
		
		if(s.length() - start > (4 - step) * 3) return;     //多出来了
		if(s.length() - start < (4 - step)) return;        //不够放
		
		int num = 0;
		for(int i = start; i < start + 3 && i < s.length(); i++){
			num = num * 10 + (s.charAt(i) - '0');
			
			if(num <= 255){
				ip = ip + s.charAt(i);           //撤销状态直接在此处覆写 不明显
				dfs(s, i + 1, step + 1, ip + '.', result);      //状态扩展直接写入参数 所以当return之后 ip还是没有‘.’ 自然的进行了撤销状态
			}
			if(num == 0) break;   //如果出现了一个0 则不会往下考虑 直接break 回到上一层
		}
	}
}

public class IPAddress {

	public static void main(String[] args) {
		
		System.out.println(new Solution_106().restoreIpAddresses("9999999"));
		System.out.println(new solution_leetcode().restoreIpAddresses("0000"));

	}

}
