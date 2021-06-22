/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution
// Time complexity: O(n)
// Space comlexity: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode d = new ListNode(0);
        d.next = head;
        head = d;
        
        while (head != null && head.next != null && head.next.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = n1.next;
            
            n1.next = n2.next;
            n2.next = n1;
            
            head.next = n2;
            head = n1;
        }
        return d.next;
    }
}
