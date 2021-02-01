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
// Space complexity: O(h)
class Solution {
    private int ans;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        ans = Integer.MIN_VALUE;
        _maxPathSum(root);
        return ans;
    }
    private int _maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(0, _maxPathSum(root.left));
        int r = Math.max(0, _maxPathSum(root.right));
        int sum = root.val + l + r;
        ans = Math.max(ans, sum);
        return Math.max(l, r) + root.val;
    }
}
