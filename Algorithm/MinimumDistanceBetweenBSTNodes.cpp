/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDiffInBST(TreeNode* root) {
        min_diff_ = INT_MAX;
        prev_ = nullptr;
        minDiff(root);
        return min_diff_;
    }
private:
    int min_diff_;
    int* prev_;
    void minDiff(TreeNode* root) {
        if (root == nullptr) return;
        minDiff(root->left);
        if (prev_ != nullptr)
            min_diff_ = min(min_diff_, abs(root->val - *prev_));
        prev_ = &root->val;
        minDiff(root->right);
    }
};
