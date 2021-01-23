/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution: Recursion
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val
               && isMirror(root1.right, root2.left)
               && isMirror(root1.left, root2.right);
    }
}
