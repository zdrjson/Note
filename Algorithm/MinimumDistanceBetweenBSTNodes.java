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
// Solution 1: In order traversal
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    private int min_diff_;
    private int prev_;
    public int minDiffInBST(TreeNode root) {
        min_diff_ = Integer.MAX_VALUE;
        prev_ = 0;
        minDiff(root);
        return min_diff_;
    }
    private void minDiff(TreeNode root) {
        if (root == null) return;
        minDiff(root.left);
        if (prev_ != 0)
            min_diff_ = Math.min(min_diff_, Math.abs(root.val - prev_));
        prev_ = root.val;
        minDiff(root.right);
    }
}
