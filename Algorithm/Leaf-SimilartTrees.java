/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time complexity: O(n1 + n2)

//Space complexity: O(n1 + n2)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);
        return leafs1.equals(leafs2);
    }
    private void getLeafs(TreeNode root, List<Integer> leafs) {
        if (root == null) return;
        if (root.left == null && root.right == null) leafs.add(root.val);
        getLeafs(root.left, leafs);
        getLeafs(root.right, leafs);
    }
}
