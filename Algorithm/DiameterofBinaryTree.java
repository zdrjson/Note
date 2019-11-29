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
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        lp(root);
        return ans;
    }
    private int lp(TreeNode root) { //把根节点当成转折点
        if (root == null) {
            return -1;
        }
        int l = lp(root.left) + 1;
        int r = lp(root.right) + 1;
        ans = Math.max(ans, l + r);
        return Math.max(l, r); //把根节点当成非转折点
    }
}
