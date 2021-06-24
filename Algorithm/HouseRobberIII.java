/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// // Idea:
// // Compare grandparent + max of grandchildren(l.l + l.r + r.l + r.r) vs max of children (l + r)
// // Solution 1: Recursion w/o memorization
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// // 现在超时了
// class Solution {
//     public int rob(TreeNode root) {
//         if (root == null) return 0;
//         int ll = root.left != null ? rob(root.left.left) : 0;
//         int lr = root.left != null ? rob(root.left.right) : 0;
//         int rl = root.right != null ? rob(root.right.left) : 0;
//         int rr = root.right != null ? rob(root.right.right) : 0;
//         int l = rob(root.left);
//         int r = rob(root.right);
//         return Math.max(root.val + ll + lr + rl + rr, l + r);
//     }
// }

// Solution 2: Recursion w/ memorization
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    private Map<TreeNode, Integer> m_ = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (m_.containsKey(root)) return m_.get(root);
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;
        int l = rob(root.left);
        int r = rob(root.right);
        int ans = Math.max(root.val + ll + lr + rl + rr, l + r);
        m_.put(root, ans);
        return ans;
    }
}

// // Solution 3: Recursion return children's value
// // Java没有指针，暂时不知道写
// class Solution {
//     public int rob(Tree root) {
        
//     }
// }
