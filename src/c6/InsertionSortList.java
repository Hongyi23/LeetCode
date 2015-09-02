package c6;

class solution_64{
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = head;
		ListNode cur = head.next;
		
		while(cur != null){
			head = dummy.next;
			ListNode q = dummy;
			ListNode p = head;
			boolean change = false;
			while(p != cur){
				if(p.val <= cur.val){
					p = p.next;
					q = q.next;
				}else{
					q.next = cur;
					prev.next = cur.next;
					cur.next = p;
					cur = prev.next;
					change = true;
					break;
				}
			}
			if(!change){
				cur = cur.next;
				prev = prev.next;
			}
		}
		
		return dummy.next;
	}
	
	public ListNode createList(){
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		return n1;
	}
}

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode head = new solution_64().insertionSortList(new solution_64().createList());
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
