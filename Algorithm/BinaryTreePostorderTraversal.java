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
    public List<Integer> postorderTraversal(TreeNode root) {
       if(root == null) return new ArrayList<>();
        Deque<Integer> ans = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            ans.addFirst(n.val); // 0(1)
            if (n.left != null) s.push(n.left);
            if (n.right != null) s.push(n.right);
        }
        return new ArrayList<Integer>(ans);
    }
}
