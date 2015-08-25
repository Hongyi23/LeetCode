package c13;
import java.util.*;

class Solution_131 {
    public int minimumTotal(List<List<Integer>> triangle) {
        this.result = new ArrayList<>();
        
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        
        dfs(0, 0, triangle, 0);
        int solution = result.get(0);
        
        Iterator<Integer> iter = this.result.iterator();
        while(iter.hasNext()){
        	int temp = iter.next();      //一个.next就是往后走一个 所以不能用if(solution == iter.next)
        	if(temp < solution) solution = temp;
        }
        return solution;
    }
    
    private List<Integer> result;
    
    private void dfs(int step, int start, List<List<Integer>> triangle, int sum){
    	if(step == triangle.size()){
    		this.result.add(sum);
    		return;
    	}
    	
    	for(int i = start; i < start + 2 && i < triangle.get(step).size(); i++){
    		sum = sum + triangle.get(step).get(i);
    		
    		dfs(step + 1, i, triangle, sum);
    		
    		sum = sum - triangle.get(step).get(i);
    	} 	
    }
}

class solution_L{
	public int minimumTotal(List<List<Integer>> triangle){
		for(int i = triangle.size() - 2; i >= 0; i--){
			for(int j = 0; j < i + 1; j++){
				int temp = 0;
				if(triangle.get(i + 1).get(j) > triangle.get(i + 1).get(j + 1)) temp = triangle.get(i + 1).get(j + 1);
				else temp = triangle.get(i + 1).get(j);
				
				temp = temp + triangle.get(i).get(j);
				triangle.get(i).set(j, temp);      //用get set对list进行赋值操作
			}
		}
		return triangle.get(0).get(0);
	}
}

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			triangle.add(new ArrayList<Integer>());
		}
		
		triangle.get(0).add(2);
		
		triangle.get(1).add(3);
		triangle.get(1).add(4);
		
		triangle.get(2).add(6);
		triangle.get(2).add(5);
		triangle.get(2).add(7);
		
		triangle.get(3).add(4);
		triangle.get(3).add(1);
		triangle.get(3).add(8);
		triangle.get(3).add(3);
		
		System.out.println(new solution_L().minimumTotal(triangle));

	}

}
