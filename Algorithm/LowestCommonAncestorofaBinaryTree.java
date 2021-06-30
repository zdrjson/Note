/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1: Recursion
// Time complexity: O(n)
// Space complexity: O(h)
// For a given root, recursively call LCA(root.left, p, q) and LCA(root.right, p, q)
// if both returns a valid node which means p, q are in different subtrees, then root will be their LCA.
// if only one valid node returns, which means p, q are in the same subtree, return that valid node as their LCA.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null || r == null) return l == null ? r : l;
        return root;
    }
}
