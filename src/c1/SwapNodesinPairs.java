package c1;

class Solution_228 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        
        while(cur != null && cur.next != null){
        	prev.next = cur.next;
        	cur.next = cur.next.next;
        	prev.next.next = cur;
        	prev = cur;
        	cur = cur.next;
        }
        
        return dummy.next;
    }
}

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
