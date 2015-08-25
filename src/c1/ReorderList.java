package c1;

class Solution_2213 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy, prev = null;
        while(fast != null && fast.next != null){
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        prev.next = null;
        
        slow = reverse(slow);
        
        ListNode cur = dummy.next;
        while(cur.next != null){
        	ListNode tmp = cur.next;
        	cur.next = slow;
        	slow = slow.next;
        	cur.next.next = tmp;
        	cur = tmp;
        }
        cur.next = slow;
    }
    
    private ListNode reverse(ListNode head){
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	ListNode prev = dummy.next, cur = prev.next;
    	while(cur != null){
    		prev.next = cur.next;
    		cur.next = dummy.next;
    		dummy.next = cur;
    		cur = prev.next;
    	}
    	return dummy.next;
    }
}

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		


	}

}
