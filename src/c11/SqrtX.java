package c11;

public class SqrtX {
	
	public static int sqrt(int x){
		int left = 1, right = x / 2;
	
		if (x < 2) return x;
	
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(x / mid > mid) { // 不要用 x > mid * mid，会溢出
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		
		return (left==x/left)?left:left-1;
	}

	public static void main(String[] args) {

		System.out.println(sqrt(17));

	}

}
