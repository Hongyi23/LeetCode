package c6;

public class SortListDemo {
	
	public static ListNode createList(){
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		return n1;
	}
	
	    public static ListNode sortList(ListNode head) {
	        if(head == null || head.next == null) return head;
	        
	        ListNode fast = head, slow = head;
	        while(fast.next != null && fast.next.next != null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        
	        fast = slow;
	        slow = slow.next;
	        fast.next = null;
	        
	        ListNode a1 = sortList(head);
	        ListNode a2 = sortList(slow);
	        return merge(a1, a2);
	    }
	    
	    public static ListNode merge(ListNode l1, ListNode l2){
	        ListNode dummy = new ListNode(-1);
	        ListNode p = dummy;
	        
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        
	        while(l1 != null && l2 != null){
	            if(l1.val > l2.val){
	                p.next = l2;
	                l2 = l2.next;
	                p = p.next;
	            }else{
	                p.next = l1;
	                l1 = l1.next;
	                p = p.next;
	            }
	        }
	        
	        if(l1 == null) p.next = l2;
	        if(l2 == null) p.next = l1;
	        
	        return dummy.next;
	    }


	public static void main(String[] args) {
		ListNode head = createList();
		head = sortList(head);
		
		for(;head != null; head = head.next){
    		System.out.println(head.val);
    	}

	}

}
