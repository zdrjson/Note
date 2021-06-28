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
// Solution: Two dummy heads
// Time complexity; O(n)
// Space complexity: O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dl = new ListNode(0);
        ListNode dr = new ListNode(0);
        ListNode l = dl;
        ListNode r = dr;
        while (head != null) {
            ListNode h = (head.val < x) ? l : r;
            h = h.next = head;
            if (head.val < x) // Java这里的h不是l的引用，所以这样用h来写的话，还要给l和r赋值回去。
                l = h;
            else 
                r = h;
            head = head.next;
        }
        r.next = null; // important, to avoid loop
        l.next = dr.next;
        return dl.next;
    }
}
