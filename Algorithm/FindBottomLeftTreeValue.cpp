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
    int findBottomLeftValue(TreeNode* root) {
        int max_row = -1;
        int ans;
        inorder(root, 0, max_row, ans);
        return ans;
    }
private:
    void inorder(TreeNode* root, int row, int& max_row, int& ans) {
        if (root == nullptr) return;
        inorder(root->left, row + 1, max_row, ans);
        if (row > max_row) {
            ans = root->val;
            max_row = row;
        }
        inorder(root->right, row + 1, max_row, ans);
    }
};
