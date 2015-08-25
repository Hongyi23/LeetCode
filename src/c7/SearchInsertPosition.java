package c7;


public class SearchInsertPosition {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int n = matrix[0].length;
        int m = matrix.length;
        
        int first = 0;
        int last = m * n;
        
        while(first < last){     //写成等号的话 如果last = first 而value > target 则进入last = mid 的死循环
        	int mid = first + (last - first) / 2;
        	int value = matrix[mid / n][mid % n];
        	
        	if(value == target) return true;
        	else if(value < target) first = mid + 1;
        	else last = mid;
        }
        
        if(first == last && matrix[first / n][first % n] == target) return true;
        else return false;
    }

	public static int searchPosition(int[] data, int target){
		
		if(data == null) return -1;
		
		int first = 0;
		int last = data.length - 1;
		
		while(first != last){
			int mid = (first + last) / 2;
			if(target > data[mid]) first = mid + 1;
			else last = mid;
		}
		
//		if(data[first] < target) return first + 1;
//		else return first;
		
		return first;
		
	}

	public static void main(String[] args) {
		int[][] a = {{1, 3, 5, 7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};

		System.out.println(searchMatrix(a, 24));
	}

}
