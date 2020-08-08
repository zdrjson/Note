/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
// // Solution 0: Cheating! store the nodes in an array
// class Solution {
// public:
//     ListNode* removeNthFromEnd(ListNode* head, int n) {
//         if (!head) return nullptr;
//         vector<ListNode *> nodes;
//         ListNode *cur = head;
//         while (cur) {
//             nodes.push_back(cur);
//             cur = cur->next;
//         }
//         if (n == nodes.size()) return head->next;
//         ListNode* nodes_to_remove = nodes[nodes.size()-n];
//         ListNode* parent = nodes[nodes.size() - n - 1];
//         parent->next = nodes_to_remove->next;
//         delete nodes_to_remove;
//         return head;
//     }
// };

// // Solution 1: Two passes
// // Time complexity: O(L)
// // Space complexity: O(1)
// class Solution {
// public:
//     ListNode* removeNthFromEnd(ListNode* head, int n) {
//         int l = 0;
//         ListNode *cur = head;
//         while (cur) {
//             ++l;
//             cur = cur->next;
//         }
//         if (n == l) {
//             ListNode* ans = head->next;
//             delete head;
//             return ans;
//         }
//         l -= n;
//         cur = head;
//         while (--l) cur = cur->next;
//         ListNode* node = cur->next;
//         cur->next = node->next;
//         delete node;
//         return head;
//     }
// };

// Solution 2: Fast/Slow Pointers + Dummy Head / Prev
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* fast = head;
        for (int i = 0; i < n; ++i)
            fast = fast->next;
        ListNode dummy(0);
        dummy.next = head;
        ListNode* prev = &dummy;
        while (fast) {
            fast = fast->next;
            prev = prev->next;
        }
        ListNode* node = prev->next;
        prev->next = node->next;
        delete node;
        return dummy.next;
    }
};
