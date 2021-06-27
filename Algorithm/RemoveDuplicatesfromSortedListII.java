/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Solution:
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head != null) {
            int c = 0;
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
                ++c;
            }
            if (c == 0)
                p = p.next = head;
            else 
                p.next = null;
            head = head.next;
        }
        return dummy.next;
    }
}
