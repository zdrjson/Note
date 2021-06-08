/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// // Solution: Recrusion
// // Time comlexity: O(n)
// // Space complexity: O(h)
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         inorderTraversal(root, ans);
//         return ans;
//     }
//     private void inorderTraversal(TreeNode root, List<Integer> ans) {
//         if (root == null) return;
//         inorderTraversal(root.left, ans);
//         ans.add(root.val);
//         inorderTraversal(root.right, ans);
//     }
// }

// Solution: Iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.peek(); s.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
