package c1;

class Solution_2118{
	int climbStairs(int n) {
		int prev = 0;
		int cur = 1;
		for(int i = 1; i <= n ; ++i){
			int tmp = cur;
			cur += prev;
			prev = tmp;
		}
		return cur;
	}
}

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new Solution_2118().climbStairs(4));

	}

}
