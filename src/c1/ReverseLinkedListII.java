package c1;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        for(int i = 0; i < m - 1; i++){
        	prev = prev.next;
        }
        ListNode start = prev;
        
        prev = start.next;
        ListNode cur = prev.next;
        for(int i = m; i < n; i++){
        	prev.next = cur.next;
        	cur.next = start.next;
        	start.next = cur;
        	cur = prev.next;
        }
        
        return dummy.next;
    }
}

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
