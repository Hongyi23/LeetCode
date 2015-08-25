package c10;

import java.util.ArrayList;
import java.util.List;

class Solution_104 {
    public List<List<String>> solveNQueens(int n) {
        this.columns = new int[n];
        this.main_diag = new int[2 * n - 1];     //边长n的矩阵有2n-1条主副对角线
        this.anti_diag = new int[2 * n - 1];     //from 0 to 2n-2
        
        List<List<String>> result = new ArrayList<>();
        int[] c = new int[n];
        dfs(c, result, 0);
        return result;
    }
    
    private int[] columns;
    private int[] main_diag;
    private int[] anti_diag;
    
    private void dfs(int[] c, List<List<String>> result, int row){
    	int N = c.length;
    	
    	if(row == N){
    		List<String> solution = new ArrayList<>();
    		for(int i = 0; i < N; i++){
    			char[] str = new char[N];
    			for(int j = 0; j < N; j++){
    				if(c[i] == j){
    					str[j] = 'Q';
    				}else{
    					str[j] = '.';
    				}
    			}
    			solution.add(new String(str));
    		}
    		result.add(solution);
    		return;
    	}
    	
    	for(int j = 0; j < N; j++){
    		boolean ok = this.columns[j] == 0 && this.main_diag[row + j] == 0 && this.anti_diag[row - j + N - 1] == 0;
    		if(!ok) continue;
    		
    		c[row] = j;
    		this.columns[j] = this.main_diag[row + j] = this.anti_diag[row - j + N - 1] = 1;
    		
    		dfs(c, result, row + 1);
    		
    		c[row] = 0;
    		this.columns[j] = this.main_diag[row + j] = this.anti_diag[row - j + N - 1] = 0;
    	}
    }
}

public class NQueens {

	public static void main(String[] args) {
		
		int num = 0;
		for(List<String> str : new Solution_104().solveNQueens(4)){
			for(String str_1 : str){
				System.out.println(str_1);
				num++;
			}
			System.out.println();
		}

	}

}
