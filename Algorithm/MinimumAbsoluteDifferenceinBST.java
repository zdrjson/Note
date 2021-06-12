/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Sorting via inorder traversal gives us sorted values, compare current one with previous one to reduce sapce complexity from O(n) to O(h).
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> sorted = new ArrayList<>(); 
        inorder(root, sorted); // 这里sorted用临时变量和全局变量都可以运行，答案都对。
        int min_diff = sorted.get(sorted.size() - 1);
        for (int i = 1; i < sorted.size(); ++i)
            min_diff = Math.min(min_diff, sorted.get(i) - sorted.get(i - 1));
        return min_diff;
    }
    private void inorder(TreeNode root, List<Integer> sorted) {
        if (root == null) return;
        inorder(root.left, sorted);
        sorted.add(root.val);
        inorder(root.right, sorted);
    }
}

// // Time complexity: O(n)
// // Space complexity O(h)/O(logn)
// class Solution {
//     private Integer prev_;
//     private int min_diff_;
//     public int getMinimumDifference(TreeNode root) {
//         prev_ = null;
//         min_diff_ = Integer.MAX_VALUE;
//         inorder(root);
//         return min_diff_;
//     }
//     private void inorder(TreeNode root) {
//         if (root == null) return;
//         inorder(root.left);
//         if (prev_ != null) min_diff_ = Math.min(min_diff_, root.val - prev_);
//         prev_ = root.val;
//         inorder(root.right);
//     }
// }
