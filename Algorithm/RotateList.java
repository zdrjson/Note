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
// Solution: Find the prev of the new head
// Step 1: Get the tail node T while counting the length of the list.
// Step 2: k %= 1, k can be greater than l, rotate k % l times has the same effect
// Step 3: Find the previous node P of the new head N by moving (l - k - 1) steps from head
// Step 4: set P.next to null, T.next to head and return N
// Time complexity: O(n) n is the length of the list
// Space complexity: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int l = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            ++l;
        }
        k %= l;
        if (k == 0) return head;
        
        ListNode prev = head;
        for (int i = 0; i < l - k - 1; ++i) {
            prev = prev.next;
        }
        
        ListNode new_head = prev.next;
        prev.next = null;
        tail.next = head;
        return new_head;
    }
}
