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
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head) return nullptr;
        ListNode dummy = ListNode(0);
        ListNode *p = &dummy;
        while (head) {
            int c = 0;
            while (head->next && head->next->val == head->val) {
                head = head->next;
                ++c;
            }
            if (c == 0)
                p = p->next = head;
            else
                p->next = nullptr;
            head = head->next;
        }
        return dummy.next;
    }
};
