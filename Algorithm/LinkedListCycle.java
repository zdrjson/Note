/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Not use the memory
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }
}


// Use the memory
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> visited = new HashSet<>();
//         while(head != null) {
//             if (visited.contains(head)) {
//                 return true;
//             }
//             visited.add(head);
//             head = head.next;
//         }
//         return false;
//     }
// }
