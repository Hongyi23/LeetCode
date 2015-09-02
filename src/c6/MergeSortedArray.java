package c6;

class Solution_61 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, psum = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
        	nums1[psum--] = (nums1[p1] >= nums2[p2])? nums1[p1--] : nums2[p2--];
        }
        while(p2 >= 0){
        	nums1[psum--] = nums2[p2--];
        }
    }
}

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
