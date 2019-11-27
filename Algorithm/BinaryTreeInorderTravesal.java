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
    public List<Integer> inorderTraversal(TreeNode root) {
       // if (root == null) {
       //     return new ArrayList<Integer>();
       // }
       List<Integer> ans = new ArrayList<Integer>();
       Stack<TreeNode> s = new Stack<>();
       TreeNode curr = root;
       while (curr  != null || !s.isEmpty()) {
              while (curr != null) {
                 s.push(curr);
                 curr = curr.left;
              }
              curr = s.pop();
              ans.add(curr.val);
              curr = curr.right;
       }
       return ans;
    }
}
