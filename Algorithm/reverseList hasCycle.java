public Boolean hasCycle(ListNode head) {
	if(head==null) return false;
	ListNode walker = head;
	ListNode runner = head;
	while(runner.next!=null && runner.next.next!=null) {
		walker = walker.next;
		runner = runner.next.next;
		if (walker==runner) return true;
	}
	return false;
}

public class Solution {
	public ListNode reverseList1(ListNode head) {
		ListNode node = head;
		ListNode pre = null;
		while (node != null) {
			ListNode nex = node.next;
			pre = node;
			node = nex;
		}
		return pre;
	}
	
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode nex = head.next;
		ListNode newHead = reverseList(hex);
		nex.next = head;
		head.next = null;
		return newHead;
	}
}