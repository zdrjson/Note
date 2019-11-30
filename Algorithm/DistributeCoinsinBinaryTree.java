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
    private int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        balance(root);
        return ans;
    }
    private int balance(TreeNode root) {
        if (root == null) return 0;
        int l = balance(root.left);
        int r = balance(root.right);
        ans += (Math.abs(l) + Math.abs(r));
        return l + r + root.val - 1;
    }
}
