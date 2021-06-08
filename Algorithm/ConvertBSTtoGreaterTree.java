/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution: reversed inorder traaversal
// in a BST, we can visit every node in the decreasing order. Using a member sum to track the sum of all visited nodes.
class Solution {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        rinorder(root);
        return root;
    }
    private void rinorder(TreeNode root) {
        if (root == null) return;
        rinorder(root.right);
        root.val = (sum += root.val);
        rinorder(root.left);    
    }
}
