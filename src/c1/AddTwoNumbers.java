package c1;

class Solution_221 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);   //always keep track of the head
        int carry = 0;
        ListNode prev = dummy;    //prev用作将answer序列逐渐向后生成
        for(;l1 != null || l2 != null; 
        		l1 = (l1 == null)? null : l1.next,
        		l2 = (l2 == null)? null : l2.next,
        		prev = prev.next){
        	
        	int a = (l1 == null)? 0 : l1.val;
        	int b = (l2 == null)? 0 : l2.val;
        	int val = (a + b + carry) % 10;               //如果题目给你一个字符串表示的数字让逐位相加
        	carry = (a + b + carry) / 10;                 //就采用这种手段 记录carry 和val 
        	prev.next = new ListNode(val);
        	
        }
        if(carry > 0){
        	prev.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode a = new ListNode(9);
		a.next = new ListNode(7);
		
		ListNode b = new ListNode(3);
		b.next = new ListNode(5);
		
		for(ListNode i = new Solution_221().addTwoNumbers(a, b); i != null; i = i.next){
			System.out.println(i.val);
		}

	}

}
