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
// Idea:
// 1.use fast / slow pointers to find the middle node and see whether the list has odd/even number of elements.
// 2. Reverse the right half the list, and compare with the left half
// E.g.
// 1->2->3->4->3->2->1->null
// fast = null
// slow = 4
// slow->next = 3
// reverse(slow->next)
// null<-3<-2<-1 compare with 1->2->3->...
// Solution: 1
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if fast != nullptr, list had odd numbers
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
