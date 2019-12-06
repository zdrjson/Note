/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int l_;
    private int r_;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        l_ = 0;
        r_ = 0;
        nodes(root, x);
        int p = n - (1 + l_ + r_);
        return Math.max(p, Math.max(l_, r_)) > n / 2;
    }
    private int nodes(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int l = nodes(root.left, x);
        int r = nodes(root.right, x);
        if (root.val == x) {
            l_ = l;
            r_ = r;
        }
        return 1 + l + r;
    }
}
