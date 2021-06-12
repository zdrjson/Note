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
// Time complexity: O(logn ~ n)
// Space complexity: O(logn ~ n)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) 
            return root;
        else if (val > root.val) 
            return searchBST(root.right, val);
        return searchBST(root.left, val);
    }
}
