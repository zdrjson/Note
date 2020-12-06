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
// Solution: List Operations
// Find the following nodes:
// 1.previous node to the a-th node: prev_a
// 2.the b-th node: node_b
// 3.tail node of list2:tail2
// prev_a->next = list2
// tail2->next = node_b
// return list1
// Time complexity: O(m+n)
// Space complexity: O(1)
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev_a = dummy;
        for (int i = 0; i < a; ++i) prev_a = prev_a.next;
        ListNode node_b = prev_a.next;
        for (int i = a; i <= b; ++i) node_b = node_b.next;
        ListNode tail2 = list2;
        while (tail2.next != null) tail2 = tail2.next; // 注意while循环判断条件。
        
        prev_a.next = list2;
        tail2.next = node_b;
        
        return list1;
    }
}
