package c1;

class Solution_223 {
    public ListNode partition(ListNode head, int x) {
        ListNode left_dummy = new ListNode(-1);
        ListNode right_dummy = new ListNode(-1);
        
        ListNode left_cur = left_dummy;
        ListNode right_cur = right_dummy;
        
        for(ListNode cur = head; cur; cur = cur.next){
        	if(cur.val < x){
        		left_cur.next = cur;
        		left_cur = left_cur.next;
        	}else{
        		right_cur.next = cur;
        		right_cur = right_cur.next;
        	}
        }
        left_cur.next = right_dummy.next;
        right_cur.next = null;
        
        return left_dummy.next;
    }
}

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
