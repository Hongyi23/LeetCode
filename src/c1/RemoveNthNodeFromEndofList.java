package c1;

class Solution_227 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        
        for(int i = 0; i < n; i++){
        	p = p.next;
        }
        while(p.next != null){
        	p = p.next;
        	q = q.next;
        }
        
        q.next = q.next.next;
        return dummy.next;
    }
}

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
