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
// Two passes. First pass, find the length of the list. Second pass, record the k-th and n-k+1 -th node. Once done swap their values.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int l = 0;
        ListNode cur = head;
        while (cur != null) { cur = cur.next; ++l; }
        
        cur = head;
        ListNode n1 = null;
        ListNode n2 = null;
        for (int i = 1; i <= l; ++i, cur = cur.next) {
            if (i == k) n1 = cur;
            if (i == l - k + 1) n2 = cur;
        }
        int tmp = n1.val; // Java像C++这样用swap方法交换要自己写方法，传过去后是临时变量，实际交换不了。
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }
}
