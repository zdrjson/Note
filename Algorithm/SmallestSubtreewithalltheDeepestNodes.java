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
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    class Pair {
        public int depth;
        public TreeNode node;
        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return depth(root).node;
    } 
    
    private Pair depth(TreeNode root) {
        if (root == null) return new Pair(-1, null);
        Pair l = depth(root.left);
        Pair r = depth(root.right);
        int dl = l.depth;
        int dr = r.depth;
        return new Pair(Math.max(dl, dr) + 1, dl == dr ? root : (dl > dr) ? l.node : r.node );
    }
}


