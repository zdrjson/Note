/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Solution 1: Inorder traversal with depth info
// The first node visited in the deepest row is the answer.
class Solution {
    private int max_row;
    private int ans;
    public int findBottomLeftValue(TreeNode root) {
        max_row = -1;
        ans = 0;
        inorder(root, 0);
        return ans;
    }
    private void inorder(TreeNode root, int row) {
        if (root == null) return;
        inorder(root.left, row + 1);
        if (row > max_row) {
            ans = root.val;
            max_row = row;
        }
        inorder(root.right, row + 1);
    }
}
