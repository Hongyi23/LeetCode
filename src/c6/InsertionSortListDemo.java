package c6;


 //Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class InsertionSortListDemo {
	
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
	
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        if(head == null){
            return head;
        }
        
        for(ListNode cur = head.next, cur_former = head; cur != null;){
            ListNode temp = cur.next;
            ListNode p, former;
            for(p = dummy.next,former = dummy; p != cur;){
                if(p.val > cur.val){
                    former.next = cur;
                    cur_former.next = cur.next;
                    cur.next = p;
                    break;
                }else{
                    p = p.next;
                    former = former.next;
                }
            }
            if(p == cur){       //no need to change, renew cur_f and cur
                cur_former = p;
                cur = temp;
            }else{              //has already changed, renew only cur, because cur_former is in the right place
                cur = temp;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String args[]){
    	ListNode head = createList();
    	head = insertionSortList(head);
    	
    	for(;head != null; head = head.next){
    		System.out.println(head.val);
    	}
    }
}