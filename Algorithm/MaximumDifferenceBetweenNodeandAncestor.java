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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, root.val, root.val);
    }
    private int maxDiff(TreeNode root, int l, int r) { // l 表示当前祖先的最小值 l 表示当前祖先的最大值
        if (root == null) {
            return 0;
        }
        int curr = Math.max(Math.abs(root.val - l), Math.abs(root.val - r));
        l = Math.min(l, root.val);
        r = Math.max(r, root.val);
        return Math.max(curr, Math.max(maxDiff(root.left, l, r), maxDiff(root.right, l, r)));
    }
}
