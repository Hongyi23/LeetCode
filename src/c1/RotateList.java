package c1;

class Solution_226 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
        	len++;
        	cur = cur.next;
        }
        
        cur.next = head;
        
        k = len - k % len;
        
        for(int step = 0; step < k; step++){
        	cur = cur.next;
        }
        
        head = cur.next;
        cur.next = null;
        return head;
    }
}

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
