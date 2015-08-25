package c9;

import java.util.ArrayList;
import java.util.LinkedList;

class point{
	public int x;
	public int y;
	public point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Solution{
	public char[][] createMap(){
		char[][] chessboard = new char[5][5];
		
		chessboard[0][0] = 'X';
		chessboard[0][1] = 'X';
		chessboard[0][2] = 'X';
		chessboard[0][3] = 'X';
		chessboard[0][4] = 'X';
		
		chessboard[1][0] = 'O';
		chessboard[1][1] = 'O';
		chessboard[1][2] = 'X';
		chessboard[1][3] = 'O';
		chessboard[1][4] = 'X';
		
		chessboard[2][0] = 'X';
		chessboard[2][1] = 'X';
		chessboard[2][2] = 'O';
		chessboard[2][3] = 'O';
		chessboard[2][4] = 'X';
		
		chessboard[3][0] = 'X';
		chessboard[3][1] = 'O';
		chessboard[3][2] = 'X';
		chessboard[3][3] = 'X';
		chessboard[3][4] = 'X';
		
		chessboard[4][0] = 'X';
		chessboard[4][1] = 'O';
		chessboard[4][2] = 'O';
		chessboard[4][3] = 'O';
		chessboard[4][4] = 'X';
		
		return chessboard;
	}
	
	public void solve(char[][] chessboard){
		if(chessboard == null || chessboard.length == 0 || chessboard[0].length == 0) return;
		
		int m = chessboard.length;
		int n = chessboard[0].length;
		
		for(int i = 0; i < n; i++){
			bfsTraverse(chessboard, 0, i);
			bfsTraverse(chessboard, m - 1, i);
		}
		for(int j = 1; j < m - 1; j++){
			bfsTraverse(chessboard, j, 0);
			bfsTraverse(chessboard, j, n - 1);
		}
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(chessboard[i][j] == 'O') chessboard[i][j] = 'X';
				else if(chessboard[i][j] == '+') chessboard[i][j] = 'O';
			}
		}
	}
	
	public void print(char[][] chessboard){
		int m = chessboard.length;
		int n = chessboard[0].length;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(chessboard[i][j]);
			}
			System.out.println();
		}
	}
	
	private void bfsTraverse(char[][] chessboard, int i, int j){
		LinkedList<point> q = new LinkedList<>();
		
		int m = chessboard.length;
		int n = chessboard[0].length;
		
		point curPoint = new point(i, j);
		if(isValid(curPoint, chessboard)){
			chessboard[i][j] = '+';
			q.add(curPoint);
		}
		while(!q.isEmpty()){
			point root = q.poll();
			ArrayList<point> chl = state_extend(root, chessboard);
			if(chl != null){     //要记住判断是否有可以extend的state
				for(point a : chl){
					q.add(a);
				}
			}
		}
	}
	
	private boolean isValid(point cur, char[][] chessboard){
		int m = chessboard.length;
		int n = chessboard[0].length;
		if(cur.x < 0 || cur.x >= m || cur.y < 0 || cur.y >= n || chessboard[cur.x][cur.y] != 'O'){
			return false;
		}
		return true;
	}
	
	private ArrayList<point> state_extend(point cur, char[][] chessboard){
		ArrayList<point> result = new ArrayList<>();
		point[] new_states = new point[4];     //先初始化一下对象数组
		
		new_states[0] = new point(cur.x - 1, cur.y);    //之后每个对象都要初始化
		new_states[1] = new point(cur.x + 1, cur.y);
		new_states[2] = new point(cur.x, cur.y - 1);
		new_states[3] = new point(cur.x, cur.y + 1);
		
		for(int i = 0; i < 4; i++){
			if(isValid(new_states[i], chessboard)){
				chessboard[new_states[i].x][new_states[i].y] = '+';
				result.add(new_states[i]);
			}
		}
		
		return result;
	}
}

public class SurrendedRegions {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		char[][] chessboard = sol.createMap();
		
		sol.print(chessboard);
		System.out.println();
		sol.solve(chessboard);		
		sol.print(chessboard);
	}

}
