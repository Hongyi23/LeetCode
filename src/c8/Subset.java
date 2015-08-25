package c8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SubsetSolution{
	public List<List<Integer>> subsets(int[] nums) {
		LinkedList<Integer> result = new LinkedList<>();
        List<List<Integer>> solution = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return solution;
        
        insertion_sort(nums);
        
        dfs_v2(nums, 0, result, solution);
        return solution;
        
    }
	
	private void dfs(int[] nums, int step, LinkedList<Integer> result, List<List<Integer>> solution){
		if(step == nums.length){
			ArrayList<Integer> temp = new ArrayList<>();     //��ס һ��Ҫ��temp ��Ϊresultֵ�ı仯��Ӱ��solution�е�ֵ ���Ա��봴��һ���µ�list��Ž��
			Iterator<Integer> iter = result.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			solution.add(temp);
			return;
		}
		// not choose
		dfs(nums, step + 1, result, solution);
		// choose it
		result.add(nums[step]);
		dfs(nums, step + 1, result, solution);
		result.pollLast();
	}
	
	private void dfs_v2(int[] nums, int start, LinkedList<Integer> result, List<List<Integer>> solution){
		{//����Ⲣ����һ��Ҫ�ﵽ������������� ���Դ˴�ֻҪ�ݽ�һ�� �ͼ�һ�����
			ArrayList<Integer> temp = new ArrayList<>();     //��ס һ��Ҫ��temp ��Ϊresultֵ�ı仯��Ӱ��solution�е�ֵ ���Ա��봴��һ���µ�list��Ž��
			Iterator<Integer> iter = result.iterator();
			while(iter.hasNext()){
				temp.add(iter.next());
			}
			solution.add(temp);
		}
		//�������� ��Ϊi start from start ���Բ������ظ�
		for(int i = start; i < nums.length; i++){
			
			result.add(nums[i]);
			dfs_v2(nums, i + 1, result, solution);
			result.pollLast();
		}
	}
	
	private void insertion_sort(int input[]){      //��ǰ���汾
		for(int i = 1; i < input.length; i++){
			int val = input[i];
			for(int j = 0; j < i; j++){
				if(input[j] > val){
					System.arraycopy(input, j, input, j + 1, i - j);
					input[j] = val;
					break;
				}
			}
		}
	}
}

public class Subset {

	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		System.out.println(new SubsetSolution().subsets(input));

	}

}
