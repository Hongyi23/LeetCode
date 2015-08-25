package c10;

class WordSolution{
	public boolean exist(char[][] board, String word) {
        this.found = false;
		int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(board[i][j] == word.charAt(0)){
        			visited[i][j] = true;
        			dfs(i, j, 0, word, board, visited);
        			if(this.found) return true;
        		}
        	}
        }
        return false;
        
    }
	
	private boolean found;
	
	private void dfs(int i, int j, int step, String word, char[][] board, boolean[][] visited){
		if(step == word.length() - 1){
			this.found = true;
			return;
		}
		
		int m = board.length;     //ÐÐ
        int n = board[0].length;   //ÁÐ
		
		if((j - 1 >= 0) && board[i][j - 1] == word.charAt(step + 1) && visited[i][j - 1] == false){
			visited[i][j - 1] = true;
			dfs(i, j - 1, step + 1, word, board, visited);
			if(this.found) return;
		}

		if((j + 1 < n) && board[i][j + 1] == word.charAt(step + 1) && visited[i][j + 1] == false){
			visited[i][j + 1] = true;
			dfs(i, j + 1, step + 1, word, board, visited);
			if(this.found) return;
		}

		if((i - 1 >= 0) && board[i - 1][j] == word.charAt(step + 1) && visited[i - 1][j] == false){
			visited[i - 1][j] = true;
			dfs(i - 1, j, step + 1, word, board, visited);
			if(this.found) return;
		}

		if((i + 1 < m) && board[i + 1][j] == word.charAt(step + 1) && visited[i + 1][j] == false){
			visited[i + 1][j] = true;
			dfs(i + 1, j, step + 1, word, board, visited);
			if(this.found) return;
		}
		
		visited[i][j] = false;
		return;
	}
}

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'},
				};
		
		System.out.println(new WordSolution().exist(board, "ABCB"));

	}

}
