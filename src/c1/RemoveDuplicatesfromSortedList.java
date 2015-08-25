package c1;

import sun.security.krb5.internal.NetClient;

class Solution_224 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode cur = head;
        ListNode next = cur.next;
        
        while(next != null){
        	if(cur.val == next.val){
        		cur.next = next.next;
        		next = next.next;
        	}else{
        		cur.next = next;
        		cur = cur.next;
        		next = cur.next;
        	}
        }
        
        return dummy.next;
    }
    
    public ListNode deleteDuplicates_1(ListNode head) {
    	if(head == null) return head;
        
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        while(cur != null){
            boolean dup = false;
        	while(cur.next != null && cur.val == cur.next.val){
        		cur = cur.next;
        		dup = true;
        	}
        	if(dup){
        	    cur = cur.next;
        	    continue;
        	}
        	
        	prev.next = cur;
        	prev = prev.next;
        	if(prev == null) break;
        	cur = cur.next;
        }
        prev.next = cur;
        return dummy.next;
    }
}

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
