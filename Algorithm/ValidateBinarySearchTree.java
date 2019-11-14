/**
 * Solution 1
 * Traverse the tree and limit the range of each subtree and check whether root’s value is in the range.
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 *
 * Note: in order to cover the range of -2^31 ~ 2^31-1, we need to use long or nullable integer.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min)
                || (max != null && root.val >= max)) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}