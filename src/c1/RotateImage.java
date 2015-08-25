package c1;

public class RotateImage {
	
	public static void rotate(int[][] matrix) {
	    int n=matrix.length;
	    for (int i=0; i<n/2; i++){ 
	        for (int j=i; j<n-i-1; j++) {
	            int tmp=matrix[i][j];
	            matrix[i][j]=matrix[n-j-1][i];
	            matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
	            matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
	            matrix[j][n-i-1]=tmp;            
	        }
	    }
	}
	
	public static void rotate_1(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
        
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
    }


	public static void main(String[] args) {
		int[][] matrix_1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		rotate_1(matrix);
	}

}
