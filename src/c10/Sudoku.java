package c10;

import java.util.ArrayList;
import java.util.TreeSet;

class solution_1010{
	public char[][] solveSudoku(char[][] board) {
        this.found = false;
        char[][] result = new char[9][9];
        ArrayList<TreeSet<Integer>> visited = new ArrayList<>();
        for(int i = 0; i < 9; i++){
        	TreeSet<Integer> temp = new TreeSet<>();
        	visited.add(temp);
        }
        dfs(board, 0, 0, visited, result);
        return result;
    }
	
	private boolean found;
	
	private void dfs(char[][] board, int start, int line, ArrayList<TreeSet<Integer>> visited, char[][] result){
		if((start == 9) && (line == 2 || line == 5 || line == 8)){
			if(!check(line, board)) return;

			if(line == 8){                                  //数独的最后一个空需要填 的情况下 solution found
				this.found = true;
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						result[i][j] = board[i][j];
					}
				}
				return;
			}else{                                          //line 为2或5的情况下 一行结束 进入下一行
				dfs(board, 0, line + 1, visited, result);
			}
		}
		
		if(line == 9){                                  //数独的最后一个空不需要填 此时start不等于9 进入line + 1循环 line == 9 表示solution found
			this.found = true;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					result[i][j] = board[i][j];
				}
			}
			return;
		}
		
		if(start == 9){     //某行的最后一个空需要填的时候
			dfs(board, 0, line + 1, visited, result);
		}
		
		if(this.found == true) return;
		
		if(start == 0){      //a new line
			for(int i = 0; i < 9; i++){
				if(board[line][i] != '.'){
					visited.get(line).add(board[line][i] - '0');
				}
			}
		}
				
		for(int row = start; row < 9; row++){
			if(board[line][row] == '.'){
				for(int i = 1; i <= 9; i++){
					if(visited.get(line).contains(i)) continue;
					
					board[line][row] = (char) (i + '0');
					visited.get(line).add(i);
					
					dfs(board, row + 1, line, visited, result);
					
					if(this.found) return;
					
					visited.get(line).remove(i);
					board[line][row] = '.';
				}
			}else if(visited.get(line).size() == 9){
				if(line == 2 || line == 5 || line == 8){
					if(!check(line, board)) return;
				}
				dfs(board, 0, line + 1, visited, result);
			}
		}
	
	}
	
	private boolean check(int line, char[][] board){
		TreeSet<Integer> visited = new TreeSet<>();
		for(int count = 0; count < 3; count++){
			for(int i = line - 2; i <= line; i++){
				for(int j = count * 3; j <= count * 3 + 2; j++){
					if(board[i][j] == '.') return false;
					visited.add(board[i][j] - '0');
				}
			}
			if(visited.size() != 9) return false;
			visited.clear();
		}
		return true;
	}
}

public class Sudoku {

	public static void main(String[] args) {
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
							{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
							{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
							{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
							{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
							{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
							{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
							{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
							{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		
		char[][] board_easy = {{'5', '3', '4', '6', '7', '8', '9', '1', '.'},
								{'6', '7', '2', '1', '9', '5', '3', '4', '.'},
								{'1', '9', '8', '3', '4', '2', '5', '6', '.'},
								{'8', '5', '9', '7', '6', '1', '4', '.', '3'},
								{'4', '2', '6', '8', '5', '3', '7', '.', '1'},
								{'7', '1', '3', '9', '2', '4', '8', '.', '6'},
								{'9', '6', '1', '5', '3', '7', '2', '8', '.'},
								{'2', '8', '7', '4', '1', '9', '6', '.', '5'},
								{'3', '4', '5', '2', '8', '6', '.', '7', '9'}};
		
		char[][] board_medium = {{'5', '3', '4', '6', '7', '8', '.', '.', '.'},
								{'6', '7', '2', '1', '9', '5', '.', '.', '.'},
								{'1', '9', '8', '3', '4', '2', '.', '6', '.'},
								{'8', '5', '9', '7', '6', '1', '.', '.', '3'},
								{'4', '2', '6', '8', '5', '3', '.', '.', '1'},
								{'7', '1', '3', '9', '2', '4', '.', '.', '6'},
								{'9', '6', '1', '5', '3', '7', '2', '8', '.'},
								{'2', '8', '7', '4', '1', '9', '.', '.', '5'},
								{'3', '4', '5', '2', '8', '6', '.', '7', '9'}};
		
		char[][] board_hard = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
								{'6', '7', '2', '1', '9', '5', '.', '.', '.'},
								{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
								{'8', '5', '9', '.', '6', '.', '.', '.', '3'},
								{'4', '2', '6', '8', '.', '3', '.', '.', '1'},
								{'7', '1', '3', '.', '2', '.', '.', '.', '6'},
								{'.', '6', '1', '.', '.', '.', '2', '8', '.'},
								{'.', '8', '7', '4', '1', '9', '.', '.', '5'},
								{'.', '4', '5', '.', '8', '.', '.', '7', '9'}};
		
		
		char[][] board_1 = {{'.', '.', '.', '2', '.', '.', '3', '8', '.'},
							{'.', '.', '.', '.', '4', '.', '.', '.', '9'},
							{'.', '6', '5', '1', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '5', '.'},
							{'.', '8', '1', '.', '.', '5', '.', '9', '.'},
							{'.', '7', '.', '.', '.', '8', '.', '3', '2'},
							{'6', '2', '.', '.', '7', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '9', '.', '.', '4', '3'},
							{'.', '.', '4', '3', '.', '.', '.', '.', '.'}};
		
//		char[][] solution_easy = new solution_1010().solveSudoku(board_easy);
//		char[][] solution_medium = new solution_1010().solveSudoku(board_medium);
//		char[][] solution_hard = new solution_1010().solveSudoku(board_hard);
		
		char[][] solution = new solution_1010().solveSudoku(board_1);
		
//		boolean flag = true;
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
//				if(solution_easy[i][j] != solution_hard[i][j]) flag = false;
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
		
//		System.out.println(flag);

	}

}
