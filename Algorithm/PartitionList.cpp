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
    ListNode* partition(ListNode* head, int x) {
        ListNode dl(0);
        ListNode dr(0);
        ListNode* l = &dl;
        ListNode* r = &dr;
        while (head) {
            ListNode*& h = (head->val < x) ? l : r;
            h = h->next = head;
            head = head->next;
        }
        r->next = nullptr; // important, to avoid loop
        l->next = dr.next;
        return dl.next;
    }
};
