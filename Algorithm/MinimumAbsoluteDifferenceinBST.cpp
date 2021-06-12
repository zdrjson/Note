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
// // O(n) space 
// class Solution {
// public:
//     int getMinimumDifference(TreeNode* root) {
//         std::vector<int> sorted;
//         inorder(root, sorted);
//         int min_diff = sorted.back();
//         for (int i = 1; i < sorted.size(); ++i)
//             min_diff = min(min_diff, sorted[i] - sorted[i - 1]);
//         return min_diff;
//     }
// private:
//     void inorder(TreeNode* root, std::vector<int>& sorted) {
//         if (!root) return;
//         inorder(root->left, sorted);
//         sorted.push_back(root->val);
//         inorder(root->right, sorted);
//     }
// };

// O(h) space
class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        min_diff_ = INT_MAX;
        prev_ = nullptr;
        inorder(root);
        return min_diff_;
    }
private:
    void inorder(TreeNode* root) {
        if (!root) return;
        inorder(root->left);
        if (prev_) min_diff_ = min(min_diff_, root->val - *prev_);
        prev_ = &root->val;
        inorder(root->right);
    }
    
    int* prev_;
    int min_diff_;
};
