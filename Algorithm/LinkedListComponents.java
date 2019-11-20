/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> g = new HashSet<>();
        for (int a : G) {
            g.add(a);
        }
        int ans = 0;
        while(head != null) {
            if (g.contains(head.val) && (head.next == null || !g.contains(head.next.val))) {
                ++ans;
            }
            head = head.next;
        }
        return ans;
    }
}