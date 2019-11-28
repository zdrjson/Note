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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }
    private List<List<Integer>> bfs(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<TreeNode> curr = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
            ans.add(new ArrayList<Integer>());
            for (TreeNode node : curr) {
                ans.get(ans.size() - 1).add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            List<TreeNode> tempList = curr;
            curr = next;
            next = tempList;
            next.clear();
        }
        return ans;
    }
}
