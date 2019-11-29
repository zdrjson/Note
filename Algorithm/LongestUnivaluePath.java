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
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        univalPath(root);
        return ans;
    }
    private int univalPath(TreeNode root) {
        if (root == null) return 0;
        int l = univalPath(root.left);
        int r = univalPath(root.right);
        int pl = 0;
        int pr = 0;
        if (root.left != null && root.val == root.left.val) pl = l + 1;
        if (root.right != null && root.val == root.right.val) pr = r + 1;
        ans = Math.max(ans, pl + pr);
        return Math.max(pl, pr);
    }
}
